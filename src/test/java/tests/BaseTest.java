package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import config.ConfigReader;
import driver.DriverFactory;
import driver.DriverManager;
import pages.LoginPage;

    public class BaseTest {

        @BeforeMethod
        public void setUp() {
            WebDriver driver = DriverFactory.createDriver(ConfigReader.get("browser"));
            DriverManager.setDriver(driver);
        }

        @AfterMethod(alwaysRun = true)
        public void tearDown() {
            DriverManager.quitDriver();
        }

    }
