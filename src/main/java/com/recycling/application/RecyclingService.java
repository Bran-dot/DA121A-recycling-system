package com.recycling.application;

import com.recycling.domain.Product;
import com.recycling.domain.Material;
import com.recycling.domain.Category;
import com.recycling.strategies.ImpactCalculationStrategy;
import java.util.ArrayList;
import java.util.List;

public class RecyclingService {
    private List<Product> products;
    private List<Material> materials;
    private ImpactCalculationStrategy currentStrategy;
    
    public RecyclingService(ImpactCalculationStrategy strategy) {
        this.products = new ArrayList<>();
        this.materials = new ArrayList<>();
        this.currentStrategy = strategy;
    }
    
    // Product management
    public Product createProduct(String name, Category category, int lifespan) {
        Product product = new Product(name, category, lifespan);
        products.add(product);
        return product;
    }
    
    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
    
    public Product findProductById(String productId) {
        return products.stream()
            .filter(p -> p.getProductId().equals(productId))
            .findFirst()
            .orElse(null);
    }
    
    // Material management
    public Material createMaterial(String name, double impactValue, String recyclingCategory) {
        Material material = new Material(name, impactValue, recyclingCategory);
        materials.add(material);
        return material;
    }
    
    public List<Material> getAllMaterials() {
        return new ArrayList<>(materials);
    }
    
    public Material findMaterialByName(String name) {
        return materials.stream()
            .filter(m -> m.getName().equalsIgnoreCase(name))
            .findFirst()
            .orElse(null);
    }
    
    // Add material to product
    public boolean addMaterialToProduct(String productId, String materialName) {
        Product product = findProductById(productId);
        Material material = findMaterialByName(materialName);
        
        if (product != null && material != null) {
            product.addMaterial(material);
            return true;
        }
        return false;
    }
    
    // Impact calculation
    public double calculateProductImpact(Product product) {
        return product.calculateImpact(currentStrategy);
    }
    
    // Change strategy
    public void setStrategy(ImpactCalculationStrategy strategy) {
        this.currentStrategy = strategy;
    }
    
    public ImpactCalculationStrategy getCurrentStrategy() {
        return currentStrategy;
    }
}
