package org.example.util;

import java.util.regex.Pattern;

/**
 * Utility class for common validation operations.
 */
public final class ValidationUtils {
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"
    );

    private static final Pattern PHONE_PATTERN = Pattern.compile(
        "^\\+?[1-9]\\d{6,14}$"  // Minimum 7 digits, maximum 15 digits (including first digit)
    );

    private ValidationUtils() {
        // Private constructor to prevent instantiation
    }

    /**
     * Validates if the given string is a valid email address.
     *
     * @param email the email address to validate
     * @return true if the email is valid
     */
    public static boolean isValidEmail(String email) {
        if (StringUtils.isEmpty(email)) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }

    /**
     * Validates if the given string is a valid phone number.
     * Accepts international format with optional + prefix.
     *
     * @param phoneNumber the phone number to validate
     * @return true if the phone number is valid
     */
    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (StringUtils.isEmpty(phoneNumber)) {
            return false;
        }
        return PHONE_PATTERN.matcher(phoneNumber).matches();
    }

    /**
     * Validates if a number is within a specified range.
     *
     * @param value the number to validate
     * @param min the minimum value (inclusive)
     * @param max the maximum value (inclusive)
     * @return true if the number is within range
     */
    public static boolean isInRange(int value, int min, int max) {
        return value >= min && value <= max;
    }
}