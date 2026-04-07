package com.recycling.strategies;

import com.recycling.domain.Product;
import com.recycling.domain.Material;

public class WeightedImpactStrategy implements ImpactCalculationStrategy {
    
    @Override
    public double calculate(Product product) {
        double totalImpact = 0.0;
        for (Material material : product.getMaterials()) {
            // Weight by impact value * 1.5 for weighted calculation
            totalImpact += material.getImpactValue() * 1.5;
        }
        return totalImpact;
    }
}
