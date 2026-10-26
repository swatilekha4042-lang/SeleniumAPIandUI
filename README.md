# Selenium API and UI Automation

A Maven-based Java 21 automation project for browser UI and REST API testing. It uses Selenium WebDriver, TestNG, Rest Assured, JSON Schema validation, and ExtentReports.

## Project Structure

```text
SeleniumAPIandUI/
├── pom.xml                         # Dependencies and Maven test configuration
├── testng.xml                      # Test suite: Bing, SauceDemo, QSpiders, Product API
├── screenshots/                    # UI failure screenshots
└── src/
    ├── main/java/
    │   ├── config/                  # ConfigReader
    │   ├── driver/                  # DriverFactory, DriverManager
    │   └── reporting/               # ExtentManager, ExtentTestManager
    └── test/
        ├── java/
        │   ├── api/                 # ApiClient, APIRequestSpec, ProductApi
        │   ├── listeners/           # TestListener
        │   ├── pages/               # BasePage, BingPage, LoginPage, qspidersLoginPage
        │   ├── tests/               # BingTest, LoginTest, qspidersLoginTest,
        │   │                        # ProductApiTest and shared base tests
        │   └── utils/               # Reporting, screenshots, JSON schema validation
        └── resources/
            ├── config.properties    # URLs, browser, and demo login credentials
            └── schemas/             # API response JSON schemas
```

## Test Coverage

- `BingTest`: search dropdown interaction.
- `LoginTest`: SauceDemo login and data-driven login cases.
- `qspidersLoginTest`: browser-window switching; the iframe login test is disabled.
- `ProductApiTest`: GET product records, check HTTP 200 and non-empty data, and validate the response schema.

The suite is run through `testng.xml` by Maven Surefire. The configured browser is Chrome; UI tests require a compatible local browser.

## Configuration

Edit `src/test/resources/config.properties` to set `url`, `username`, `password`, `bingUrl`, `qSpidersUrl`, `browser`, and `api.Url`. These are currently demo/test service settings; avoid putting real credentials in the file.

## Run and Reports

From the project root:

```bash
mvn clean test
```

- ExtentReports: `test-output/ExtentReport.html`
- Maven Surefire reports: `target/surefire-reports/`
