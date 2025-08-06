package org.example.util;

/**
 * Utility class for string operations.
 */
public final class StringUtils {

    private StringUtils() {
        // Private constructor to prevent instantiation
    }

    /**
     * Checks if a string is null or empty.
     *
     * @param str the string to check
     * @return true if the string is null or empty
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    /**
     * Reverses a string.
     *
     * @param str the string to reverse
     * @return the reversed string, or null if input is null
     */
    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    /**
     * Capitalizes the first letter of each word in a string.
     *
     * @param str the string to capitalize
     * @return the capitalized string, or null if input is null
     */
    public static String capitalizeWords(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder result = new StringBuilder();
        String[] words = str.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) {
                result.append(Character.toUpperCase(words[i].charAt(0)))
                      .append(words[i].substring(1).toLowerCase());
            }
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}