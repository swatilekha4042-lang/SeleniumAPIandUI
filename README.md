# Selenium API and UI Automation

This project is a Java-based automation framework for testing both UI and API flows using Selenium, TestNG, Rest Assured, and Extent Reports. It includes login automation for SauceDemo, browser-based UI testing, and API validation for product endpoints.

## Overview

The framework is built with Maven and follows a page object model (POM) style for UI tests and a service-based approach for API tests. It supports:

- Selenium WebDriver automation for browser-based scenarios
- TestNG test execution with XML suite configuration
- API testing with Rest Assured
- JSON schema validation
- Detailed HTML reporting with Extent Reports
- Centralized configuration via properties files

## Tech Stack

- Java 21
- Maven
- Selenium WebDriver 4.35.0
- TestNG 7.11.0
- Rest Assured 5.5.6
- Jackson Databind 2.19.2
- JSON Schema Validator 1.5.6
- ExtentReports 5.1.2

## Project Structure

```text
PracticeSelenium/
├── pom.xml
├── testng.xml
├── README.md
├── src/
│   ├── test/
│   │   ├── java/
│   │   │   ├── api/
│   │   │   │   ├── ApiClient.java
│   │   │   │   ├── APIRequestSpec.java
│   │   │   │   └── ProductApi.java
│   │   │   ├── listeners/
│   │   │   │   └── TestListener.java
│   │   │   ├── pages/
│   │   │   │   ├── BasePage.java
│   │   │   │   ├── BingPage.java
│   │   │   │   ├── LoginPage.java
│   │   │   │   └── qspidersLoginPage.java
│   │   │   ├── tests/
│   │   │   │   ├── ApiBaseTest.java
│   │   │   │   ├── BaseTest.java
│   │   │   │   ├── BingTest.java
│   │   │   │   ├── LoginTest.java
│   │   │   │   ├── ProductApiTest.java
│   │   │   │   └── qspidersLoginTest.java
│   │   │   └── utils/
│   │   │       ├── ConfigReader.java
│   │   │       ├── DriverFactory.java
│   │   │       ├── DriverManager.java
│   │   │       ├── ExtentManager.java
│   │   │       ├── ExtentTestManager.java
│   │   │       ├── ReportUtils.java
│   │   │       ├── SchemaValidator.java
│   │   │       └── ScreenshotUtils.java
│   │   └── resources/
│   │       ├── config.properties
│   │       └── schemas/
│   │           └── AllProductsSchema.json
├── screenshots/
├── target/
├── test-output/
│   └── ExtentReport.html
└── surefire-reports/
```

## Configuration

The main test configuration is stored in:

- `src/test/resources/config.properties`

The file contains environment and application settings such as:

- base URL for SauceDemo
- username and password
- Bing URL
- browser selection
- API base URL

Example configuration:

```properties
url=https://www.saucedemo.com/
username=standard_user
password=secret_sauce
bingUrl=https://www.bing.com/?cc=in
browser=chrome
api.Url=https://reqres.in/api
```

## Test Suite

The TestNG suite is configured in `testng.xml`.

Current suite setup executes the API test class:

```xml
<test name="Fourth Selenium Test">
    <classes>
        <class name="tests.ProductApiTest"/>
    </classes>
</test>
```

## Available Test Scenarios

### UI tests
- Login flow validation using SauceDemo
- Multiple login scenarios via TestNG data provider
- Browser navigation checks

### API tests
- GET all products request
- Response status validation
- Response body verification
- JSON schema validation

## Running the Tests

From the project root, run:

```bash
mvn clean test
```

This will compile the project, execute the TestNG suite, and generate reports in the `target` folder.

## Reports

The framework generates:

- Surefire report under `target/surefire-reports/`
- Extent HTML report under `test-output/ExtentReport.html`

## Notes

- ChromeDriver/browser compatibility should be checked locally before running browser tests.
- Selenium and API tests can be extended by adding more page objects and reusable API methods.
- For CI execution, the suite can be customized by changing `testng.xml`.

## Example Usage

```bash
# Run all tests
mvn test

# Clean and rerun
mvn clean test
```

## License

This project is intended for learning and practice purposes in Selenium and API automation testing.
