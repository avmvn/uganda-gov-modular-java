Uganda Government Modular Java System

## Modules
- gov.common: shared API used by other modules
- gov.nationalid: national ID management
- gov.tax: tax collection
- gov.passport: passport processing, requires gov.nationalid
- gov.business: business registration
- gov.app: main application

## Why modularization helps
- Security: only exported packages are accessible; internal packages stay hidden from other modules.
- Maintainability: each department works on its own module independently.
- Scalability: new services can be added as new modules without changing existing ones.

## How to run
Open the project in IntelliJ IDEA and run the main class in gov.app.
