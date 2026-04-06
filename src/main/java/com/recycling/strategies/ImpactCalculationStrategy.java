package com.recycling.strategies;

import com.recycling.domain.Product;

public interface ImpactCalculationStrategy {
    double calculate(Product product);
}