# E Commerce QA Automation Framework

A production style QA automation framework built with Java, Selenium WebDriver, REST Assured, JUnit 5, Gradle, GitHub Actions, and Allure.

This project validates critical e commerce functionality across both the user interface and API layer. It is designed to demonstrate maintainable test architecture, reusable automation, CI execution, cross browser testing, API validation, negative testing, and failure diagnostics.

## Project Goals

The goal of this project is to simulate the type of automated testing framework used in a real Software Quality Engineering environment.

The framework focuses on

* UI automation with Selenium WebDriver
* API automation with REST Assured
* Page Object Model design
* Positive and negative testing
* Smoke and regression coverage
* Cross browser testing
* REST API validation
* Reusable test architecture
* CI execution with GitHub Actions
* Failure screenshots and test evidence
* Maintainable and readable automation code

## Application Under Test

The framework tests Automation Exercise, a public e commerce application designed for automation practice.

The project covers both browser based user workflows and available API functionality.

### UI Coverage

Automated UI testing includes

* Login
* Invalid authentication
* Product search
* Product selection
* Cart management
* Checkout
* Form validation
* Logout
* Negative scenarios
* End to end customer workflows

### API Coverage

Automated API testing includes

* GET requests
* POST requests
* PUT requests
* DELETE requests
* HTTP status code validation
* Response body validation
* Required field validation
* Invalid request handling
* Invalid user scenarios
* Product API validation
* User API validation
* Search API validation
* Negative API testing

## Technology Stack

| Technology | Purpose |
| --- | --- |
| Java | Automation programming language |
| Selenium WebDriver | Browser automation |
| REST Assured | REST API automation |
| JUnit 5 | Test execution and assertions |
| Gradle | Build and dependency management |
| GitHub Actions | Continuous integration |
| Allure | Test reporting |
| Chrome | Browser validation |
| Firefox | Cross browser validation |

## Framework Architecture

The project separates UI automation, API automation, browser configuration, page interactions, utilities, and reusable setup logic.

```text
src/test/java
├── base
│   ├── BaseTest.java
│   └── BaseApiTest.java
│
├── config
│   └── DriverFactory.java
│
├── pages
│   ├── HomePage.java
│   ├── LoginPage.java
│   ├── ProductsPage.java
│   ├── CartPage.java
│   └── CheckoutPage.java
│
├── tests
│   ├── ui
│   │   ├── LoginTests.java
│   │   ├── ProductTests.java
│   │   ├── CartTests.java
│   │   └── CheckoutTests.java
│   │
│   └── api
│       ├── ProductApiTests.java
│       ├── UserApiTests.java
│       ├── SearchApiTests.java
│       └── NegativeApiTests.java
│
├── models
│   └── User.java
│
└── utils
    ├── WaitUtils.java
    ├── ScreenshotUtils.java
    ├── TestWatcherExtension.java
    └── TestData.java
```

GitHub Actions workflows are stored in

```text
.github/workflows
```

The workflows include

```text
smoke-tests.yml
regression-tests.yml
api-tests.yml
```

## Test Strategy

The framework separates tests by purpose and risk.

### Smoke Testing

Smoke tests cover critical workflows that should remain stable after every code change.

Examples include

* Application loads successfully
* Login functionality remains available
* Products can be viewed
* Products can be added to the cart
* Critical APIs respond successfully

Smoke tests are intended to run quickly and provide immediate feedback during development.

### Regression Testing

Regression tests provide broader coverage across application functionality.

Examples include

* Invalid login behavior
* Missing required information
* Product search
* Cart updates
* Product removal
* Checkout validation
* Navigation behavior
* Cross browser functionality

Regression tests run across Chrome and Firefox.

### API Testing

API tests validate backend behavior independently from the browser.

The API suite verifies

* Successful requests
* Invalid requests
* Expected HTTP response codes
* Response content
* Required response fields
* Error responses
* Product data
* User data
* Search behavior
* Create, update, and delete operations where supported

## UI Test Design

The Selenium portion of the framework uses the Page Object Model.

Page classes contain element locators and browser interactions while test classes focus on expected application behavior.

This separation improves

* Reusability
* Readability
* Maintainability
* Debugging
* Scalability

## API Test Design

REST Assured is used to send requests directly to the Automation Exercise API.

Reusable API configuration is handled separately from individual test scenarios.

This allows tests to focus on behavior such as

```text
Send Request
↓
Validate Status Code
↓
Validate Response Body
↓
Validate Required Fields
↓
Evaluate Expected Behavior
```

The API suite includes both positive and negative scenarios to verify how the service responds to valid and invalid input.

## Running the Tests

Run the complete test suite

```bash
./gradlew test
```

Run smoke tests

```bash
./gradlew smokeTest
```

Run regression tests

```bash
./gradlew regressionTest
```

Run regression tests in headless mode

```bash
./gradlew regressionTest -Dheadless=true
```

Run regression tests using Firefox

```bash
./gradlew regressionTest -Dbrowser=firefox
```

Run API tests

```bash
./gradlew apiTest
```

## Continuous Integration

GitHub Actions automatically executes test suites as part of the CI workflow.

### UI Smoke Pipeline

```text
Pull Request
↓
Set Up Java
↓
Build Project
↓
Run Selenium Smoke Tests
↓
Upload Test Results
↓
Pass or Fail
```

### Regression Pipeline

```text
Scheduled or Manual Run
↓
Set Up Java
↓
Run Regression Suite
↓
Execute Chrome Tests
↓
Execute Firefox Tests
↓
Upload Reports and Screenshots
↓
Pass or Fail
```

### API Pipeline

```text
Code Change
↓
Set Up Java
↓
Run REST Assured Tests
↓
Validate Responses
↓
Generate Test Results
↓
Pass or Fail
```

## Failure Diagnostics

When a UI test fails, the framework captures a screenshot before the browser session closes.

Screenshots are stored in

```text
build/screenshots
```

GitHub Actions can upload screenshots and test reports as workflow artifacts so failures can be investigated without rerunning the test locally.

API failures include response information and assertion details to make unexpected behavior easier to investigate.

## Current Automated Coverage

### UI Testing

| Area | Example Coverage |
| --- | --- |
| Authentication | Valid login, invalid login, empty credentials |
| Products | Search, product details, product selection |
| Cart | Add product, remove product, quantity validation |
| Checkout | Successful checkout, required field validation |
| Navigation | Login, products, cart, checkout, logout |
| Negative Testing | Invalid credentials, missing data, unexpected input |

### API Testing

| Area | Example Coverage |
| --- | --- |
| GET | Retrieve products, users, and search results |
| POST | Submit supported requests and validate responses |
| PUT | Update supported resources |
| DELETE | Validate supported delete behavior |
| Status Codes | Validate expected success and error responses |
| Response Body | Verify returned data and required fields |
| Negative Testing | Invalid IDs, missing values, unsupported requests |

## Quality Engineering Practices Demonstrated

This project demonstrates hands on experience with

* Selenium WebDriver
* REST Assured
* Java automation development
* JUnit 5
* Page Object Model
* UI testing
* API testing
* Functional testing
* Regression testing
* Smoke testing
* Negative testing
* Cross browser testing
* Test case design
* HTTP request validation
* Response validation
* Explicit waits
* Reusable automation utilities
* Failure diagnostics
* CI integration
* GitHub Actions
* Gradle
* Git based development workflows

## Planned Enhancements

Future improvements include

* JSON schema validation
* Data driven testing
* Parameterized API tests
* Automated Allure report publishing
* Parallel test execution
* Docker based test execution
* Expanded end to end workflows
* API driven test data setup
* Combined API and UI validation scenarios
* Additional CI quality gates

## Why I Built This

I built this project to strengthen my automation engineering skills and create something that reflects how Software Quality Engineering works beyond individual test scripts.

I wanted the project to cover more than browser clicks, so the framework combines UI automation, API testing, negative testing, CI integration, debugging, and reusable architecture.

My goal is to keep expanding the framework while learning how to build automated tests that are reliable, maintainable, and useful to an engineering team.

## Author

**Jasmyn Medina**

Software Quality Assurance Engineer

M.S. Computer Science student at Georgia Tech

[LinkedIn](https://linkedin.com/in/jasmyn-medina-3a0028421)

[GitHub](https://github.com/jasmynmedina)
