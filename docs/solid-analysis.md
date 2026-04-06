# SOLID Principles Analysis - Week 3

## S - Single Responsibility Principle (SRP)
*A class should have only one reason to change.*

**Current design:**
- Product class: only handles product data and impact calculation
- ProductService: only handles product/material coordination
- RecyclingApp: only handles UI and user input

**Verdict:** ✅ Good separation of concerns

---

## O - Open/Closed Principle (OCP)
*Classes should be open for extension but closed for modification.*

**Current design:**
- ImpactCalculationStrategy interface allows new strategies without modifying Product class
- New impact calculation methods can be added by creating new strategy classes

**Verdict:** ✅ Strategy pattern supports OCP

---

## L - Liskov Substitution Principle (LSP)
*Subtypes must be substitutable for their base types.*

**Current design:**
- All strategy implementations can replace ImpactCalculationStrategy interface
- No inheritance hierarchy issues

**Verdict:** ✅ Good

---

## I - Interface Segregation Principle (ISP)
*Clients should not be forced to depend on interfaces they don't use.*

**Current design:**
- ImpactCalculationStrategy has only one method (calculate)
- No fat interfaces

**Verdict:** ✅ Good

---

## D - Dependency Inversion Principle (DIP)
*Depend on abstractions, not concretions.*

**Current design:**
- Product depends on ImpactCalculationStrategy interface (not concrete classes)
- RecyclingApp depends on ProductService abstraction

**Verdict:** ✅ Good

---

## Identified Design Weaknesses

### Weakness 1: ProductService knows too much
ProductService currently handles both product AND material management. This violates SRP.

**Improvement:** Split into ProductService and MaterialService.

### Weakness 2: No validation in Product class
Product attributes (lifespan, category) have no validation.

**Improvement:** Add validation in setters and constructor.

### Weakness 3: RecyclingGuidance is separate but could be inside Material
Recycling guidance depends on material data, so it could be a method in Material class.

**Improvement:** Move getGuidance() to Material class.

---

## Design Improvements Applied

| Weakness | Improvement |
|----------|-------------|
| ProductService handles too much | Split into ProductService + MaterialService |
| No validation | Add validation in Product setters |
| RecyclingGuidance separate | Move guidance logic to Material class |