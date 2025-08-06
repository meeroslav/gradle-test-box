package org.example.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility class for common date operations.
 */
public final class DateUtils {
    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    private static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private DateUtils() {
        // Private constructor to prevent instantiation
    }

    /**
     * Formats a LocalDate using the default date format (yyyy-MM-dd).
     *
     * @param date the date to format
     * @return formatted date string
     */
    public static String formatDate(LocalDate date) {
        if (date == null) {
            return null;
        }
        return date.format(DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT));
    }

    /**
     * Formats a LocalDateTime using the default datetime format (yyyy-MM-dd HH:mm:ss).
     *
     * @param dateTime the datetime to format
     * @return formatted datetime string
     */
    public static String formatDateTime(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.format(DateTimeFormatter.ofPattern(DEFAULT_DATETIME_FORMAT));
    }

    /**
     * Checks if a date is in the future.
     *
     * @param date the date to check
     * @return true if the date is in the future
     */
    public static boolean isFutureDate(LocalDate date) {
        if (date == null) {
            return false;
        }
        return date.isAfter(LocalDate.now());
    }
}