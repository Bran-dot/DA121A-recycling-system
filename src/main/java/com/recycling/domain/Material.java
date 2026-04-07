package com.recycling.domain;

import java.util.UUID;

public class Material {
    private String materialId;
    private String name;
    private double impactValue;
    private String recyclingCategory;
    
    // Constructor
    public Material(String name, double impactValue, String recyclingCategory) {
        this.materialId = UUID.randomUUID().toString();
        this.name = name;
        this.impactValue = impactValue;
        this.recyclingCategory = recyclingCategory;
        
        // Validate
        validateImpactValue(impactValue);
    }
    
    // Getters
    public String getMaterialId() {
        return materialId;
    }
    
    public String getName() {
        return name;
    }
    
    public double getImpactValue() {
        return impactValue;
    }
    
    public String getRecyclingCategory() {
        return recyclingCategory;
    }
    
    // Methods
    public String getGuidance() {
        return "Recycling guidance for " + name + ": Place in " + recyclingCategory + " bin.";
    }
    
    // Validation
    private void validateImpactValue(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Impact value cannot be negative");
        }
    }
}