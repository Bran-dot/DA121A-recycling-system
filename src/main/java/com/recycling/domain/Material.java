package com.recycling.domain;

public class Material {
    private String materialId;
    private String name;
    private double impactValue;
    private String recyclingCategory;
    
    // Constructor
    public Material(String name, double impactValue, String recyclingCategory) {
        // TODO: Week 4 - implement
    }
    
    // Getters
    public String getName() {
        // TODO: Week 4 - implement
        return null;
    }
    
    public double getImpactValue() {
        // TODO: Week 4 - implement
        return 0.0;
    }
    
    public String getRecyclingCategory() {
        // TODO: Week 4 - implement
        return null;
    }
    
    // Methods
    public String getGuidance() {
        // TODO: Week 4 - implement
        return "Recycling guidance for " + name;
    }
    
    private boolean validateImpactValue(double value) {
        // TODO: Week 4 - implement
        return value >= 0;
    }
}