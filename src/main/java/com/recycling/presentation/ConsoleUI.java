package com.recycling.presentation;

import com.recycling.application.RecyclingService;
import com.recycling.domain.Product;
import com.recycling.domain.Material;
import com.recycling.domain.Category;
import com.recycling.strategies.ImpactCalculationStrategy;
import com.recycling.strategies.SimpleImpactStrategy;
import com.recycling.strategies.WeightedImpactStrategy;
import java.util.Scanner;

public class ConsoleUI {
    private RecyclingService service;
    private Scanner scanner;
    
    public ConsoleUI(RecyclingService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }
    
    public void start() {
        boolean running = true;
        
        while (running) {
            displayMenu();
            int choice = getIntInput();
            
            switch (choice) {
                case 1:
                    createProduct();
                    break;
                case 2:
                    createMaterial();
                    break;
                case 3:
                    listProducts();
                    break;
                case 4:
                    listMaterials();
                    break;
                case 5:
                    addMaterialToProduct();
                    break;
                case 6:
                    calculateImpact();
                    break;
                case 7:
                    changeStrategy();
                    break;
                case 0:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
    
    private void displayMenu() {
        System.out.println("\n=== Recycling Management System ===");
        System.out.println("1. Create Product");
        System.out.println("2. Create Material");
        System.out.println("3. List All Products");
        System.out.println("4. List All Materials");
        System.out.println("5. Add Material to Product");
        System.out.println("6. Calculate Product Impact");
        System.out.println("7. Change Calculation Strategy");
        System.out.println("0. Exit");
        System.out.print("Choice: ");
    }
    
    private void createProduct() {
        System.out.print("Product name: ");
        String name = scanner.nextLine();
        
        System.out.println("Categories: ELECTRONICS, PLASTIC, GLASS, PAPER, METAL, TEXTILE, OTHER");
        System.out.print("Category: ");
        String categoryStr = scanner.nextLine().toUpperCase();
        
        System.out.print("Lifespan (years): ");
        int lifespan = getIntInput();
        
        try {
            Category category = Category.valueOf(categoryStr);
            Product product = service.createProduct(name, category, lifespan);
            System.out.println("Product created! ID: " + product.getProductId());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private void createMaterial() {
        System.out.print("Material name: ");
        String name = scanner.nextLine();
        
        System.out.print("Impact value: ");
        double impactValue = getDoubleInput();
        
        System.out.print("Recycling category (e.g., Plastic, Metal, Glass): ");
        String recyclingCategory = scanner.nextLine();
        
        try {
            Material material = service.createMaterial(name, impactValue, recyclingCategory);
            System.out.println("Material created! ID: " + material.getMaterialId());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private void listProducts() {
        System.out.println("\n=== Products ===");
        for (Product p : service.getAllProducts()) {
            System.out.println("- " + p.getName() + " (" + p.getCategory() + ")");
            System.out.println("  Lifespan: " + p.getLifespan() + " years");
            System.out.println("  Materials: " + p.getMaterials().size());
        }
    }
    
    private void listMaterials() {
        System.out.println("\n=== Materials ===");
        for (Material m : service.getAllMaterials()) {
            System.out.println("- " + m.getName() + " (Impact: " + m.getImpactValue() + ")");
            System.out.println("  Guidance: " + m.getGuidance());
        }
    }
    
    private void addMaterialToProduct() {
        listProducts();
        System.out.print("Enter Product ID: ");
        String productId = scanner.nextLine();
        
        listMaterials();
        System.out.print("Enter Material name: ");
        String materialName = scanner.nextLine();
        
        if (service.addMaterialToProduct(productId, materialName)) {
            System.out.println("Material added to product!");
        } else {
            System.out.println("Failed to add material. Check IDs.");
        }
    }
    
    private void calculateImpact() {
        listProducts();
        System.out.print("Enter Product ID: ");
        String productId = scanner.nextLine();
        
        Product product = service.findProductById(productId);
        if (product != null) {
            double impact = service.calculateProductImpact(product);
            System.out.println("Environmental Impact: " + impact);
        } else {
            System.out.println("Product not found.");
        }
    }
    
    private void changeStrategy() {
        System.out.println("Current strategy: " + service.getCurrentStrategy().getClass().getSimpleName());
        System.out.println("1. Simple Impact Strategy");
        System.out.println("2. Weighted Impact Strategy");
        System.out.print("Choice: ");
        int choice = getIntInput();
        
        ImpactCalculationStrategy newStrategy;
        if (choice == 1) {
            newStrategy = new SimpleImpactStrategy();
        } else {
            newStrategy = new WeightedImpactStrategy();
        }
        service.setStrategy(newStrategy);
        System.out.println("Strategy changed to: " + newStrategy.getClass().getSimpleName());
    }
    
    private int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a number: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return value;
    }
    
    private double getDoubleInput() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Please enter a number: ");
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        return value;
    }
}
