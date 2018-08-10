package br.com.alan.conference.utils;

public class Strings {
    private static final String UTF8_BOM = "\uFEFF";

    public static String removeUTF8BOM(String value) {
        if (value.startsWith(UTF8_BOM)) {
            return value.substring(1);
        }
        return value;
    }
}
