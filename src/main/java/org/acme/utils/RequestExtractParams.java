package org.acme.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.quarkus.panache.common.Sort;
import io.quarkus.panache.common.Sort.Direction;
import io.vertx.core.http.HttpServerRequest;

public class RequestExtractParams {

	public static Map<String, Object> extractAttributes(HttpServerRequest request, List<String> attributes) {
		Map<String, Object> params = new HashMap<>();

		for (String attribute : attributes) {

			String param = request.getParam(attribute);

			if (StringUtils.hasText(param)) {
				params.put(attribute, param);
			}
		}
		return params;
	}

	public static Sort extractSorting(HttpServerRequest request, List<String> sorting) {

		try {
			var param = request.getParam("sort");

			var direction = param != null && param.contains("-") ? Direction.Descending : Direction.Ascending;

			var order = param.replace("-", "");

			if (sorting.contains(order))
				return Sort.by(order, direction);
			else
				return Sort.by(sorting.get(0)).ascending();

		} catch (Exception e) {
			return null;
		}
	}
}
