package com.recycling;

import com.recycling.application.RecyclingService;
import com.recycling.presentation.ConsoleUI;
import com.recycling.strategies.SimpleImpactStrategy;

public class Main {
    public static void main(String[] args) {
        // Create service with default strategy
        RecyclingService service = new RecyclingService(new SimpleImpactStrategy());
        
        // Create and start UI
        ConsoleUI ui = new ConsoleUI(service);
        ui.start();
    }
}
