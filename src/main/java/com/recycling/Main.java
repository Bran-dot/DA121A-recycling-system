package com.recycling;

import com.recycling.application.RecyclingService;
import com.recycling.presentation.ConsoleUI;
import com.recycling.strategies.SimpleImpactStrategy;

public class Main {
    public static void main(String[] args) {
        RecyclingService service = new RecyclingService(new SimpleImpactStrategy());
        ConsoleUI ui = new ConsoleUI(service);
        ui.start();
    }
}
