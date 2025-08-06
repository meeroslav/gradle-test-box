package org.example.util;

import org.example.list.LinkedList;
import org.example.utilities.StringUtils;

/**
 * Utility class for enhanced list operations.
 */
public final class ListUtils {
    private ListUtils() {
        // Private constructor to prevent instantiation
    }

    /**
     * Joins list elements and formats them with a timestamp.
     *
     * @param list the list to join
     * @return formatted string with timestamp
     */
    public static String joinWithTimestamp(LinkedList list) {
        String joined = StringUtils.join(list);
        return String.format("[%s] %s", DateUtils.formatDateTime(java.time.LocalDateTime.now()), joined);
    }

    /**
     * Splits a string into a list and validates each element is not empty.
     *
     * @param source the string to split
     * @return LinkedList containing the split elements
     * @throws IllegalArgumentException if any element is empty
     */
    public static LinkedList splitAndValidate(String source) {
        LinkedList result = StringUtils.split(source);

        // Validate each element
        for (int i = 0; i < result.size(); i++) {
            if (org.example.util.StringUtils.isEmpty(result.get(i))) {
                throw new IllegalArgumentException("List cannot contain empty elements");
            }
        }

        return result;
    }
}