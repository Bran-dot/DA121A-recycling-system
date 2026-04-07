package com.recycling.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    
    private Product product;
    private Material material;
    
    @BeforeEach
    void setUp() {
        product = new Product("Laptop", Category.ELECTRONICS, 5);
        material = new Material("Aluminum", 2.5, "Metal");
    }
    
    @Test
    void testProductCreation() {
        assertNotNull(product.getProductId());
        assertEquals("Laptop", product.getName());
        assertEquals(Category.ELECTRONICS, product.getCategory());
        assertEquals(5, product.getLifespan());
    }
    
    @Test
    void testAddMaterial() {
        product.addMaterial(material);
        assertEquals(1, product.getMaterials().size());
        assertEquals(material, product.getMaterials().get(0));
    }
    
    @Test
    void testAddMultipleMaterials() {
        Material material2 = new Material("Plastic", 1.5, "Plastic");
        product.addMaterial(material);
        product.addMaterial(material2);
        assertEquals(2, product.getMaterials().size());
    }
    
    @Test
    void testInvalidLifespan() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Product("Bad", Category.ELECTRONICS, -1);
        });
    }
    
    @Test
    void testInvalidCategory() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Product("Bad", null, 5);
        });
    }
}
