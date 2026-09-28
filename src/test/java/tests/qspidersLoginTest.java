package tests;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listeners.TestListener;
import pages.qspidersLoginPage;
import utils.ConfigReader;
import utils.DriverManager;

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
        qloginPage.goToIFrames();
        qloginPage.enterDetailsInTheFrame("Swati", "test");
    }

    @Test 
    public void browserWindow()
    {
        qloginPage.switchBrowserWindows();
    }
    
}
