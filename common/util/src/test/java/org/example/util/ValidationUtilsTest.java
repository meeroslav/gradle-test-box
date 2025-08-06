package org.example.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilsTest {

    @Test
    void isValidEmail_WithValidEmail_ReturnsTrue() {
        assertTrue(ValidationUtils.isValidEmail("test@example.com"));
        assertTrue(ValidationUtils.isValidEmail("user.name+tag@example.co.uk"));
    }

    @Test
    void isValidEmail_WithInvalidEmail_ReturnsFalse() {
        assertFalse(ValidationUtils.isValidEmail("invalid.email"));
        assertFalse(ValidationUtils.isValidEmail("@example.com"));
        assertFalse(ValidationUtils.isValidEmail("test@"));
        assertFalse(ValidationUtils.isValidEmail(null));
        assertFalse(ValidationUtils.isValidEmail(""));
    }

    @Test
    void isValidPhoneNumber_WithValidPhoneNumber_ReturnsTrue() {
        assertTrue(ValidationUtils.isValidPhoneNumber("+1234567890"));
        assertTrue(ValidationUtils.isValidPhoneNumber("1234567890"));
    }

    @Test
    void isValidPhoneNumber_WithInvalidPhoneNumber_ReturnsFalse() {
        assertFalse(ValidationUtils.isValidPhoneNumber("invalid"));
        assertFalse(ValidationUtils.isValidPhoneNumber("123"));
        assertFalse(ValidationUtils.isValidPhoneNumber(null));
        assertFalse(ValidationUtils.isValidPhoneNumber(""));
    }

    @Test
    void isInRange_WithNumberInRange_ReturnsTrue() {
        assertTrue(ValidationUtils.isInRange(5, 0, 10));
        assertTrue(ValidationUtils.isInRange(0, 0, 10)); // min boundary
        assertTrue(ValidationUtils.isInRange(10, 0, 10)); // max boundary
    }

    @Test
    void isInRange_WithNumberOutOfRange_ReturnsFalse() {
        assertFalse(ValidationUtils.isInRange(-1, 0, 10));
        assertFalse(ValidationUtils.isInRange(11, 0, 10));
    }
}