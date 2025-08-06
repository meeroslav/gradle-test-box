package org.example.appdata;

import org.example.list.LinkedList;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Represents a product in the system.
 */
public class Product {
    private final String id;
    private String name;
    private String description;
    private BigDecimal price;
    private int stockQuantity;
    private LinkedList categories;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Product(String id, String name, String description, BigDecimal price, int stockQuantity) {
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }

        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.categories = new LinkedList();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.updatedAt = LocalDateTime.now();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        this.updatedAt = LocalDateTime.now();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
        this.updatedAt = LocalDateTime.now();
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
        this.updatedAt = LocalDateTime.now();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Gets the categories of this product.
     *
     * @return the categories list
     */
    public LinkedList getCategories() {
        return categories;
    }

    /**
     * Adds a category to this product.
     *
     * @param category the category to add
     * @throws IllegalArgumentException if category is empty
     */
    public void addCategory(String category) {
        categories.add(category);
        this.updatedAt = LocalDateTime.now();
    }

    /**
     * Gets the categories as a formatted string with timestamp.
     *
     * @return formatted categories string
     */
    public String getFormattedCategories() {
        return categories.toString();
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", categories=" + getFormattedCategories() +
                '}';
    }
}