package com.recycling.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.recycling.strategies.ImpactCalculationStrategy;

public class Product {
    private String productId;
    private String name;
    private Category category;
    private int lifespan;
    private List<Material> materials;
    
    public Product(String name, Category category, int lifespan) {
        this.productId = UUID.randomUUID().toString();
        this.name = name;
        this.category = category;
        this.lifespan = lifespan;
        this.materials = new ArrayList<>();
        
        validateLifespan(lifespan);
        validateCategory(category);
    }
    
    public String getProductId() {
        return productId;
    }
    
    public String getName() {
        return name;
    }
    
    public Category getCategory() {
        return category;
    }
    
    public int getLifespan() {
        return lifespan;
    }
    
    public List<Material> getMaterials() {
        return new ArrayList<>(materials);
    }
    
    public void addMaterial(Material material) {
        if (material != null) {
            materials.add(material);
        }
    }
    
    public double calculateImpact(ImpactCalculationStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Strategy cannot be null");
        }
        return strategy.calculate(this);
    }
    
    private void validateLifespan(int lifespan) {
        if (lifespan <= 0) {
            throw new IllegalArgumentException("Lifespan must be positive");
        }
    }
    
    private void validateCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Category cannot be null");
        }
    }
}