package br.com.lucra.utils

abstract class StringUtils {

	static def String toSnakeCase(String s) {
		if(s === null) return null

		return s.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase
	}

	static def String toUpperCaseSpaced(String s) {
		if(s === null) return null

		return s.replaceAll("([a-z])([A-Z])", "$1_$2").toUpperCase
	}

	static def boolean isCamelCase(String s) {
		return s !== null && !s.equals(s.toLowerCase)
	}

	static def String capitalize(String s) {
		if(s === null || s.isEmpty()) return null

		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}
}
