package utils;

import com.aventstack.extentreports.Status;

import reporting.ExtentTestManager;

public class ReportUtils {
    public static void info(String message)
    {
       ExtentTestManager.getTest().log(Status.INFO, message);
    }
}
