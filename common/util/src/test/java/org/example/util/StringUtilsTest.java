package org.example.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void isEmpty_WithNullString_ReturnsTrue() {
        assertTrue(StringUtils.isEmpty(null));
    }

    @Test
    void isEmpty_WithEmptyString_ReturnsTrue() {
        assertTrue(StringUtils.isEmpty(""));
        assertTrue(StringUtils.isEmpty("   "));
    }

    @Test
    void isEmpty_WithNonEmptyString_ReturnsFalse() {
        assertFalse(StringUtils.isEmpty("test"));
    }

    @Test
    void reverse_WithValidString_ReturnsReversedString() {
        assertEquals("cba", StringUtils.reverse("abc"));
    }

    @Test
    void reverse_WithNull_ReturnsNull() {
        assertNull(StringUtils.reverse(null));
    }

    @Test
    void reverse_WithEmptyString_ReturnsEmptyString() {
        assertEquals("", StringUtils.reverse(""));
    }

    @Test
    void capitalizeWords_WithValidString_ReturnsCapitalizedString() {
        assertEquals("Hello World", StringUtils.capitalizeWords("hello world"));
        assertEquals("Hello World", StringUtils.capitalizeWords("HELLO WORLD"));
    }

    @Test
    void capitalizeWords_WithNull_ReturnsNull() {
        assertNull(StringUtils.capitalizeWords(null));
    }

    @Test
    void capitalizeWords_WithEmptyString_ReturnsEmptyString() {
        assertEquals("", StringUtils.capitalizeWords(""));
    }
}