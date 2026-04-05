# Requirements Analysis – Recycling Management System

## Functional Requirements

### Product Management
1. Create product with: name, category, estimated lifespan, and one or more materials
2. List all products (show name + category)
3. View detailed product information (all fields including materials)

### Material Management
4. Define reusable materials with: name, impact value, recycling category/instruction
5. Materials can be reused across multiple products

### Environmental Impact Calculation
6. Calculate product's total environmental impact
7. Support at least two interchangeable calculation strategies
8. Product class must NOT change when strategy changes

### Recycling Guidance
9. Provide recycling guidance based on product's material composition
10. Document how mixed-material products are handled

## Non-Functional Requirements

### Architecture
1. Layered architecture: Presentation, Application, Domain
2. Clear separation between UI and business logic
3. Menu-driven console application (no GUI frameworks)

### Design
4. Strategy pattern implemented and documented
5. JUnit tests for core domain logic only (no console UI in tests)

### Workflow
6. Continuous Integration (CI) that builds and runs tests automatically
7. Protected main branch with pull requests
8. Meaningful commit history

## System Boundary (what is NOT included)
- No GUI frameworks (Swing, JavaFX, etc.)
- No database persistence (optional if you choose to add it)
- No payment or logistics system
- No web interface
- No user authentication/login
