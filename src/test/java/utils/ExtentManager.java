package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    
    private static ExtentReports extentReports;

    public static synchronized ExtentReports getExtentReports()
    {
        if(extentReports==null)
        {
          ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
          extentReports=new ExtentReports();
          extentReports.attachReporter(sparkReporter);
          extentReports.setSystemInfo("OS", System.getProperty("os.name"));
          extentReports.setSystemInfo("Java", System.getProperty("java.version"));
        }
        return extentReports;
    }
}
