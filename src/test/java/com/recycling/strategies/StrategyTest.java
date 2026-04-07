package com.recycling.strategies;

import com.recycling.domain.Product;
import com.recycling.domain.Material;
import com.recycling.domain.Category;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StrategyTest {
    
    @Test
    void testSimpleImpactStrategy() {
        Product product = new Product("Test", Category.ELECTRONICS, 5);
        Material material1 = new Material("Aluminum", 2.0, "Metal");
        Material material2 = new Material("Plastic", 1.0, "Plastic");
        
        product.addMaterial(material1);
        product.addMaterial(material2);
        
        ImpactCalculationStrategy strategy = new SimpleImpactStrategy();
        double impact = strategy.calculate(product);
        
        assertEquals(3.0, impact); // 2.0 + 1.0
    }
    
    @Test
    void testWeightedImpactStrategy() {
        Product product = new Product("Test", Category.ELECTRONICS, 5);
        Material material1 = new Material("Aluminum", 2.0, "Metal");
        Material material2 = new Material("Plastic", 1.0, "Plastic");
        
        product.addMaterial(material1);
        product.addMaterial(material2);
        
        ImpactCalculationStrategy strategy = new WeightedImpactStrategy();
        double impact = strategy.calculate(product);
        
        assertEquals(4.5, impact); // (2.0 * 1.5) + (1.0 * 1.5)
    }
    
    @Test
    void testStrategySwap() {
        Product product = new Product("Test", Category.ELECTRONICS, 5);
        Material material = new Material("Steel", 3.0, "Metal");
        product.addMaterial(material);
        
        ImpactCalculationStrategy simple = new SimpleImpactStrategy();
        ImpactCalculationStrategy weighted = new WeightedImpactStrategy();
        
        assertEquals(3.0, simple.calculate(product));
        assertEquals(4.5, weighted.calculate(product));
    }
}
