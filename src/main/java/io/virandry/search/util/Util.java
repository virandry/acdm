package io.virandry.search.util;

import java.util.Collection;
import java.util.Map;

public class Util {
	
	private Util() {
		super();
	}

	public static boolean isEmpty(Object obj) {
		return obj == null;
	}

	public static boolean isEmpty(String value) {
		return value == null || value.isEmpty();
	}

	public static boolean isEmpty(Collection<?> value) {
		return value == null || value.isEmpty();
	}

	public static boolean isEmpty(Map<?, ?> value) {
		return value == null || value.isEmpty();
	}
}
