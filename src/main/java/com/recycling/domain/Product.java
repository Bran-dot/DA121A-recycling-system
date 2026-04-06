package com.recycling.domain;

import java.util.ArrayList;
import java.util.List;
import com.recycling.strategies.ImpactCalculationStrategy;

public class Product {
    private String productId;
    private String name;
    private Category category;
    private int lifespan;
    private List<Material> materials;
    
    // Constructor
    public Product(String name, Category category, int lifespan) {
        // TODO: Week 4 - implement constructor
        this.materials = new ArrayList<>();
    }
    
    // Getters
    public String getName() { 
        // TODO: Week 4 - implement
        return null; 
    }
    
    public Category getCategory() { 
        // TODO: Week 4 - implement
        return null; 
    }
    
    public int getLifespan() { 
        // TODO: Week 4 - implement
        return 0; 
    }
    
    public List<Material> getMaterials() { 
        // TODO: Week 4 - implement
        return null; 
    }
    
    // Methods
    public void addMaterial(Material material) {
        // TODO: Week 4 - implement
    }
    
    public double calculateImpact(ImpactCalculationStrategy strategy) {
        // TODO: Week 4 - implement
        return 0.0;
    }
    
    // Validation methods
    private boolean validateLifespan(int lifespan) {
        // TODO: Week 4 - implement
        return lifespan > 0;
    }
    
    private boolean validateCategory(Category category) {
        // TODO: Week 4 - implement
        return category != null;
    }
}