package br.com.lucra.utils;

@SuppressWarnings("all")
public class StringUtils {
  public String toSnakeCase(final String s) {
    if ((s == null)) {
      return null;
    }
    return s.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
  }

  public String toUpperCaseSpaced(final String s) {
    if ((s == null)) {
      return null;
    }
    return s.replaceAll("([a-z])([A-Z])", "$1_$2").toUpperCase();
  }

  public boolean isCamelCase(final String s) {
    return ((s != null) && (!s.equals(s.toLowerCase())));
  }

  public String capitalize(final String s) {
    if (((s == null) || s.isEmpty())) {
      return null;
    }
    String _upperCase = s.substring(0, 1).toUpperCase();
    String _substring = s.substring(1);
    return (_upperCase + _substring);
  }
}
