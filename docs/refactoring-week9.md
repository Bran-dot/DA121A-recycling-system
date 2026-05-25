# Week 9: Refactoring Summary

## Refactoring Performed

### 1. Extracted input validation method in ConsoleUI
**Problem:** Repeated validation code for menu choices.
**Solution:** Created `getMenuChoice(int min, int max)` method.
**Benefit:** DRY principle, easier to maintain.

### 2. Removed Scanner dependency from domain layer
**Problem:** Some domain classes had Scanner imports (layer violation).
**Solution:** Moved all I/O to presentation layer.
**Benefit:** Domain is now UI-free and testable without console.

### 3. Renamed unclear variables and methods
**Problem:** Names like `calc`, `proc`, `r` didn't communicate intent.
**Solution:** Renamed to `SimpleImpactCalculator`, `calculate()`, `totalImpact`.
**Benefit:** Code reads like documentation.

## Safety Net
- Before refactoring: `mvn test` → 8 tests passing ✅
- After each refactoring step: `mvn test` → 8 tests passing ✅
- CI pipeline remained green throughout

## Impact on Design Quality
| Metric | Before | After |
|--------|--------|-------|
| Cohesion | Low (mixed responsibilities) | High (focused classes) |
| Coupling | High (direct dependencies) | Low (interface dependencies) |
| Testability | Hard (UI mixed with logic) | Easy (pure domain tests) |

## SOLID Principles Applied
- **SRP:** Extracted validation logic into its own method
- **OCP:** Strategy pattern already in place
- **DIP:** Constructor injection for dependencies
