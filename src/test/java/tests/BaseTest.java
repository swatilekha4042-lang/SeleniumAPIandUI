package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverFactory;
import utils.DriverManager;

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
