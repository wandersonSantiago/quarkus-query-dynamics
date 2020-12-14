package org.acme.utils;

import java.util.Map;


public class QueryBuilder {
	
	public static String builderOperatorOr(Map<String, Object> params) {
		return builder(params, " OR ");
	}

	public static String builderOperatorAnd(Map<String, Object> params) {
		return builder(params, " AND ");
	}

	public static String builder(Map<String, Object> params, String operator) {

		var query = new StringBuilder();

		params.forEach((k, v) -> {

			if (v != null) {
				if (StringUtils.hasText(query))
					query.append(operator);

				query.append(k + " = " + "'" + v + "'");
			}
		});
		return query.toString();
	}

}
