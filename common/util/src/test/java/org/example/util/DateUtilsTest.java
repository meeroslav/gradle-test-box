package org.example.util;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilsTest {

    @Test
    void formatDate_WithValidDate_ReturnsFormattedString() {
        LocalDate date = LocalDate.of(2024, 3, 15);
        assertEquals("2024-03-15", DateUtils.formatDate(date));
    }

    @Test
    void formatDate_WithNull_ReturnsNull() {
        assertNull(DateUtils.formatDate(null));
    }

    @Test
    void formatDateTime_WithValidDateTime_ReturnsFormattedString() {
        LocalDateTime dateTime = LocalDateTime.of(2024, 3, 15, 14, 30, 0);
        assertEquals("2024-03-15 14:30:00", DateUtils.formatDateTime(dateTime));
    }

    @Test
    void formatDateTime_WithNull_ReturnsNull() {
        assertNull(DateUtils.formatDateTime(null));
    }

    @Test
    void isFutureDate_WithFutureDate_ReturnsTrue() {
        LocalDate futureDate = LocalDate.now().plusDays(1);
        assertTrue(DateUtils.isFutureDate(futureDate));
    }

    @Test
    void isFutureDate_WithPastDate_ReturnsFalse() {
        LocalDate pastDate = LocalDate.now().minusDays(1);
        assertFalse(DateUtils.isFutureDate(pastDate));
    }
}