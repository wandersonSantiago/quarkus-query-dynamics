package org.acme.utils;

import io.quarkus.panache.common.Page;
import io.vertx.core.http.HttpServerRequest;

public class PageUtils {

public static Page getPage(HttpServerRequest request) {
		
		int page = 0;
		int size = 20;
		int maximumPerPage = 100;
		
		String index = request.getParam("page");
		String pageSize = request.getParam("page_size");

		try {
			if (index != null)
				page = Integer.valueOf(index);
		} catch (Exception e) {
			throw new IllegalArgumentException(
					"Illegal argument to page with value " + index + ", argument valid to value page is number!");
		}

		if (pageSize != null) {
			try {
				size = Integer.valueOf(pageSize);
			} catch (Exception e) {
				throw new IllegalArgumentException("Illegal argument to page_size with value " + pageSize
						+ ", argument valid to value page_size is number!");
			}
			if (size > maximumPerPage) {
				throw new IllegalArgumentException("Illegal argument to page_size with value " + pageSize
						+ ", maximum allowed " + maximumPerPage + " per page!");
			}
		}

		return Page.of(page, size);
	}
}
