package com.recycling.application;

import com.recycling.domain.Product;
import com.recycling.domain.Material;
import com.recycling.domain.Category;
import com.recycling.strategies.ImpactCalculationStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RecyclingService {
    private List<Product> products;
    private List<Material> materials;
    private ImpactCalculationStrategy currentStrategy;
    
    public RecyclingService(ImpactCalculationStrategy strategy) {
        this.products = new ArrayList<>();
        this.materials = new ArrayList<>();
        this.currentStrategy = strategy;
    }
    
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
    
    public boolean addMaterialToProduct(String productId, String materialName) {
        Product product = findProductById(productId);
        Material material = findMaterialByName(materialName);
        if (product != null && material != null) {
            product.addMaterial(material);
            return true;
        }
        return false;
    }
    
    public double calculateProductImpact(Product product) {
        return product.calculateImpact(currentStrategy);
    }
    
    public void setStrategy(ImpactCalculationStrategy strategy) {
        this.currentStrategy = strategy;
    }
    
    public ImpactCalculationStrategy getCurrentStrategy() {
        return currentStrategy;
    }
}
