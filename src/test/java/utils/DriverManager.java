package utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(WebDriver wbdriver)
    {
        driver.set(wbdriver);
    }

    public static WebDriver getDriver()
    {
        return driver.get();
    }

    public static void quitDriver()
    {
        WebDriver webdriver= driver.get();
        try{
            if(webdriver != null){
                webdriver.quit();
            }
        }
        finally{
            driver.remove();
        }

    }
}
