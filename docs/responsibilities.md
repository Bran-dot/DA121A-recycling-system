# Responsibility-Driven Design - Week 2

## What is Responsibility-Driven Design?

Each class has two types of responsibilities:
- **Knowing** (what data/information it holds)
- **Doing** (what actions/behaviors it performs)

---

## Class Responsibilities

### Product (Domain Entity)

| Type | Responsibility |
|------|----------------|
| Knowing | Knows its name, category, lifespan, and materials |
| Doing | Can calculate its environmental impact using a strategy |
| Doing | Can add materials to itself |

### Material (Domain Entity)

| Type | Responsibility |
|------|----------------|
| Knowing | Knows its name, impact value, and recycling category |
| Doing | Can provide recycling instructions |

### ProductService (Application Service)

| Type | Responsibility |
|------|----------------|
| Knowing | Knows all products and materials in the system |
| Doing | Can create new products and materials |
| Doing | Can find and return products/materials |
| Doing | Coordinates between products and materials |

### ImpactCalculationStrategy (Strategy Pattern)

| Type | Responsibility |
|------|----------------|
| Doing | Defines how to calculate environmental impact |
| Doing | Can be swapped without changing Product class |

### RecyclingGuidance (Service)

| Type | Responsibility |
|------|----------------|
| Doing | Provides recycling guidance based on materials |
| Doing | Handles mixed-material products |

### RecyclingApp (Application Controller)

| Type | Responsibility |
|------|----------------|
| Knowing | Knows the current calculation strategy |
| Doing | Runs the console menu and handles user input |
| Doing | Delegates business logic to ProductService |

---

## Responsibility Questions to Ask

When designing a class, ask:
1. What does this class **know**?
2. What does this class **do**?
3. Is this responsibility in the **right place**?
4. Could another class do this better?
5. Does this class have **too many** responsibilities? (Single Responsibility Principle)

---

## GRASP Principles Applied

| Principle | Application |
|-----------|-------------|
| **Information Expert** | Product calculates its own impact (it has the data) |
| **Low Coupling** | Product depends on Strategy interface, not concrete classes |
| **High Cohesion** | ProductService only handles product/material coordination |
| **Controller** | RecyclingApp handles UI events, delegates to ProductService |
| **Polymorphism** | Strategy pattern allows interchangeable impact calculations |