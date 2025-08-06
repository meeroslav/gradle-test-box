package org.example.appdata;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void constructor_WithValidData_CreatesProduct() {
        Product product = new Product("1", "Test Product", "Description", new BigDecimal("99.99"), 100);

        assertEquals("1", product.getId());
        assertEquals("Test Product", product.getName());
        assertEquals("Description", product.getDescription());
        assertEquals(new BigDecimal("99.99"), product.getPrice());
        assertEquals(100, product.getStockQuantity());
        assertNotNull(product.getCreatedAt());
        assertNotNull(product.getUpdatedAt());
    }

    @Test
    void setPrice_WithValidPrice_UpdatesPrice() {
        Product product = new Product("1", "Test Product", "Description", new BigDecimal("99.99"), 100);
        product.setPrice(new BigDecimal("149.99"));

        assertEquals(new BigDecimal("149.99"), product.getPrice());
        assertTrue(product.getUpdatedAt().isAfter(product.getCreatedAt()));
    }

    @Test
    void setStockQuantity_WithValidQuantity_UpdatesStock() {
        Product product = new Product("1", "Test Product", "Description", new BigDecimal("99.99"), 100);
        product.setStockQuantity(150);

        assertEquals(150, product.getStockQuantity());
        assertTrue(product.getUpdatedAt().isAfter(product.getCreatedAt()));
    }

    @Test
    void equals_WithSameId_ReturnsTrue() {
        Product product1 = new Product("1", "Product 1", "Description 1", new BigDecimal("99.99"), 100);
        Product product2 = new Product("1", "Product 2", "Description 2", new BigDecimal("149.99"), 200);

        assertEquals(product1, product2);
        assertEquals(product1.hashCode(), product2.hashCode());
    }

    @Test
    void equals_WithDifferentId_ReturnsFalse() {
        Product product1 = new Product("1", "Test Product", "Description", new BigDecimal("99.99"), 100);
        Product product2 = new Product("2", "Test Product", "Description", new BigDecimal("99.99"), 100);

        assertNotEquals(product1, product2);
    }

    @Test
    void addCategory_WithValidCategory_AddsToList() {
        Product product = new Product("1", "Test Product", "Description", new BigDecimal("99.99"), 100);
        product.addCategory("Electronics");

        assertEquals("Electronics", product.getCategories().get(0));
        assertTrue(product.getUpdatedAt().isAfter(product.getCreatedAt()));
    }
}