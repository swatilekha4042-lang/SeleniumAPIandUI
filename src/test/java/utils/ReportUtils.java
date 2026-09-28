package utils;

import com.aventstack.extentreports.Status;

public class ReportUtils {
    public static void info(String message)
    {
       ExtentTestManager.getTest().log(Status.INFO, message);
    }
}
