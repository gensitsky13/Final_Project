# Final_project

UI automation project for the training service "Bulletin Board".

## Tech stack
- Java 11
- Maven
- Selenide
- Cucumber
- JUnit 5
- RestAssured
- Allure

## Project structure
- src/test/java – test code (steps, pages, api, utils)
- src/test/resources/features – Cucumber feature files

## How to run tests
mvn clean test

## Allure report
mvn allure:serve

## Notes
- Test users are created via API
- All tests are independent