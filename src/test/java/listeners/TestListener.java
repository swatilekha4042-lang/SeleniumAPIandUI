package listeners;



import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.DriverManager;
import utils.ScreenshotUtils;
import utils.ExtentManager;
import utils.ExtentTestManager;

public class TestListener implements ITestListener{

    @Override 
    public void onTestFailure(ITestResult result)
    {
       String  testName= result.getName();
       ExtentTestManager.getTest().log(Status.FAIL, "Test failed");
       ExtentTestManager.getTest().log(Status.FAIL, result.getThrowable());

       // Take screenshot only if this is a UI test
       WebDriver driver = DriverManager.getDriver();
       if (driver != null) {
        ScreenshotUtils.takeScreenshot(DriverManager.getDriver(), testName+"_failure");
       }
    }
    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest test =ExtentManager.getExtentReports().createTest(result.getMethod().getMethodName());
        ExtentTestManager.setTest(test);
    }


    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentTestManager.getTest().log(Status.PASS, "Test passed");
    }

     @Override
    public void onTestSkipped(ITestResult result) {

        ExtentTestManager.getTest().log(Status.SKIP, "Test skipped");
    }


    @Override
    public void onFinish(ITestContext context) {

        ExtentManager.getExtentReports().flush();
    }


}
