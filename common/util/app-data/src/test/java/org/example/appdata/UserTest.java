package org.example.appdata;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void constructor_WithValidData_CreatesUser() {
        User user = new User("1", "test@example.com", "John Doe", "+1234567890");

        assertEquals("1", user.getId());
        assertEquals("test@example.com", user.getEmail());
        assertEquals("John Doe", user.getName());
        assertEquals("+1234567890", user.getPhoneNumber());
        assertNotNull(user.getCreatedAt());
        assertNotNull(user.getUpdatedAt());
    }

    @Test
    void setEmail_WithValidEmail_UpdatesEmail() {
        User user = new User("1", "test@example.com", "John Doe", "+1234567890");
        user.setEmail("new@example.com");

        assertEquals("new@example.com", user.getEmail());
        assertTrue(user.getUpdatedAt().isAfter(user.getCreatedAt()));
    }

    @Test
    void setPhoneNumber_WithValidPhone_UpdatesPhone() {
        User user = new User("1", "test@example.com", "John Doe", "+1234567890");
        user.setPhoneNumber("+9876543210");

        assertEquals("+9876543210", user.getPhoneNumber());
        assertTrue(user.getUpdatedAt().isAfter(user.getCreatedAt()));
    }

    @Test
    void equals_WithSameId_ReturnsTrue() {
        User user1 = new User("1", "test1@example.com", "John Doe", "+1234567890");
        User user2 = new User("1", "test2@example.com", "Jane Doe", "+9876543210");

        assertEquals(user1, user2);
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    void equals_WithDifferentId_ReturnsFalse() {
        User user1 = new User("1", "test@example.com", "John Doe", "+1234567890");
        User user2 = new User("2", "test@example.com", "John Doe", "+1234567890");

        assertNotEquals(user1, user2);
    }
}