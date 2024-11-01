package SYSC4806Project;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @org.junit.jupiter.api.Test
    void getName() {
        Product product = new Product("apple", 1.50);
        assertEquals("apple", product.getName());
    }

    @org.junit.jupiter.api.Test
    void getPrice() {
    }

    @org.junit.jupiter.api.Test
    void setPrice() {
    }

    @org.junit.jupiter.api.Test
    void getTags() {
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }
}