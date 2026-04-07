package com.recycling.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MaterialTest {
    
    @Test
    void testMaterialCreation() {
        Material material = new Material("Glass", 1.2, "Glass Recycling");
        assertNotNull(material.getMaterialId());
        assertEquals("Glass", material.getName());
        assertEquals(1.2, material.getImpactValue());
        assertEquals("Glass Recycling", material.getRecyclingCategory());
    }
    
    @Test
    void testGetGuidance() {
        Material material = new Material("Paper", 0.5, "Paper Bin");
        String guidance = material.getGuidance();
        assertTrue(guidance.contains("Paper"));
        assertTrue(guidance.contains("Paper Bin"));
    }
    
    @Test
    void testInvalidImpactValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Material("Bad", -5.0, "Recycling");
        });
    }
}
