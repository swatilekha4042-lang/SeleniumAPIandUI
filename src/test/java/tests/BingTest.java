   package tests;
   import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import config.ConfigReader;
import driver.DriverManager;
import pages.BingPage;
import reporting.ExtentManager;
import reporting.ExtentTestManager;
   public class BingTest extends BaseTest{

      BingPage bingpage ;

      @BeforeMethod
      public void setUpBing()
      {
         bingpage=new BingPage(DriverManager.getDriver());
         String baseurl=ConfigReader.get("bingUrl");
         DriverManager.getDriver().get(baseurl);
      }

      @Test 
      public void searchDropdown()
      {
         ExtentTest test= ExtentTestManager.getTest();
         test.log(Status.INFO, "Starting search dropdown test");
         bingpage.selectTextInDropdown("testing");     
      }
   }