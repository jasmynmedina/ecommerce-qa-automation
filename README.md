# E Commerce QA Automation Framework

A production style UI automation framework built with Java, Selenium WebDriver, JUnit 5, Gradle, and GitHub Actions.

This project is designed to validate critical e commerce workflows through automated functional, regression, and smoke testing while demonstrating maintainable test architecture, CI integration, cross browser execution, and failure diagnostics.

## Project Goals

The goal of this project is to simulate the type of automation framework used in a real QA engineering environment.

The framework focuses on

* Reusable test architecture
* Page Object Model design
* Positive and negative testing
* Smoke and regression coverage
* Cross browser testing
* CI execution with GitHub Actions
* Failure screenshots and test evidence
* Maintainable and readable test code

## Application Under Test

The framework currently tests Automation Exercise, a public e commerce application used for automation practice.

The automated coverage includes customer workflows such as

* Login
* Invalid authentication
* Product search
* Product selection
* Cart management
* Checkout
* Form validation
* Logout
* Negative scenarios
* End to end user flows

## Technology Stack

| Technology | Purpose |
| --- | --- |
| Java | Test automation language |
| Selenium WebDriver | Browser automation |
| JUnit 5 | Test execution and assertions |
| Gradle | Build and dependency management |
| GitHub Actions | Continuous integration |
| Allure | Test reporting |
| Chrome and Firefox | Cross browser validation |

## Framework Architecture

The project follows the Page Object Model to keep test logic separate from browser interaction logic.

```text
src/test/java
├── base
│   └── BaseTest.java
├── config
│   └── DriverFactory.java
├── pages
│   ├── HomePage.java
│   ├── LoginPage.java
│   ├── ProductsPage.java
│   ├── CartPage.java
│   └── CheckoutPage.java
├── tests
│   ├── LoginTests.java
│   ├── ProductTests.java
│   ├── CartTests.java
│   └── CheckoutTests.java
└── utils
    ├── ScreenshotUtils.java
    ├── TestWatcherExtension.java
    └── WaitUtils.java
```

GitHub Actions workflows are stored in

```text
.github/workflows
```

## Test Strategy

Tests are organized into smoke and regression suites.

### Smoke Testing

Smoke tests cover critical workflows that should remain stable after every code change.

Examples include

* Application loads successfully
* User authentication works
* Products can be added to the cart
* Checkout flow remains accessible

Smoke tests run automatically on pull requests and pushes to the main branch.

### Regression Testing

Regression tests provide broader coverage across application functionality and negative scenarios.

Examples include

* Invalid login attempts
* Missing required fields
* Cart updates
* Product removal
* Checkout validation
* Cross browser behavior

Regression tests run across Chrome and Firefox.

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

Run tests in headless mode

```bash
./gradlew regressionTest -Dheadless=true
```

Run regression tests using Firefox

```bash
./gradlew regressionTest -Dbrowser=firefox
```

## Continuous Integration

GitHub Actions automatically executes automated tests as part of the CI workflow.

The pipeline

1. Checks out the repository
2. Configures Java
3. Executes Gradle
4. Runs Selenium tests in headless mode
5. Executes smoke or regression suites
6. Uploads test results
7. Captures screenshots when failures occur
8. Reports whether the build passed or failed

The regression workflow also runs tests across Chrome and Firefox to identify browser specific issues.

## Failure Diagnostics

When an automated test fails, the framework captures a screenshot before the browser closes.

Failure screenshots are stored under

```text
build/screenshots
```

GitHub Actions also uploads screenshots and test reports as workflow artifacts to make failed CI runs easier to investigate.

## Current Automated Coverage

| Area | Example Coverage |
| --- | --- |
| Authentication | Valid login, invalid login, empty credentials |
| Products | Search, product details, product selection |
| Cart | Add product, remove product, quantity validation |
| Checkout | Successful checkout, required field validation |
| Navigation | Login, products, cart, checkout, logout |
| Negative Testing | Invalid credentials, missing data, unexpected input |

Coverage will continue to expand as the framework develops.

## Quality Engineering Practices Demonstrated

This project demonstrates hands on experience with

* Selenium WebDriver automation
* Java test development
* JUnit 5
* Page Object Model
* Test case design
* Functional testing
* Regression testing
* Smoke testing
* Negative testing
* Cross browser testing
* Explicit waits
* Reusable automation utilities
* Failure diagnostics
* CI integration
* GitHub Actions
* Gradle
* Git based development workflows

## Planned Enhancements

Future improvements include

* REST API testing with REST Assured
* Data driven testing
* Parameterized test execution
* Automated Allure report publishing
* Parallel test execution
* Docker based test environments
* Expanded end to end regression coverage

## Why I Built This

I built this project to strengthen my automation engineering skills and create a framework that reflects how quality engineering works beyond individual Selenium scripts.

My goal was to focus on maintainability, test strategy, debugging, CI integration, and reliable automated feedback rather than simply automating browser clicks.

## Author

**Jasmyn Medina**

Software Quality Assurance Engineer  
M.S. Computer Science student at Georgia Tech

[LinkedIn](https://linkedin.com/in/jasmyn-medina-3a0028421)  
[GitHub](https://github.com/jasmynmedina)
