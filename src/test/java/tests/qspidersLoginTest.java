package tests;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import config.ConfigReader;
import driver.DriverManager;
import listeners.TestListener;
import pages.qspidersLoginPage;
import reporting.ExtentTestManager;

@Listeners(TestListener.class)
public class qspidersLoginTest extends BaseTest{

   qspidersLoginPage qloginPage;
   
    @BeforeMethod 
    public void setUpQspiders()
    {
         qloginPage=new qspidersLoginPage(DriverManager.getDriver());
         String baseUrl= ConfigReader.get("qSpidersUrl");
         DriverManager.getDriver().get(baseUrl);
         DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @Test (enabled=false)
    public void iFrameLogin()
    {
         ExtentTestManager.getTest().log(Status.INFO, "Verifying frame login");
        qloginPage.goToIFrames();
        qloginPage.enterDetailsInTheFrame("Swati", "test");
    }

    @Test 
    public void browserWindow()
    {
        ExtentTestManager.getTest().log(Status.INFO, "Verifying browser window switching");
        qloginPage.switchBrowserWindows();
    }
    
}
