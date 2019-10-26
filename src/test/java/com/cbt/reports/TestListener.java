package com.cbt.reports;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import java.io.IOException;

import com.cbt.utilities.Driver;
import com.cbt.utilities.UI_Helper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends ExtentTestManager implements ITestListener {
    public TestListener() {
    }

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    public void onStart(ITestContext iTestContext) {
        System.out.println("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", Driver.getDriver());
    }

    public void onFinish(ITestContext iTestContext) {
        System.out.println("I am in onFinish method " + iTestContext.getName());
        extent_report.flush();
    }

    public void onTestStart(ITestResult iTestResult) {
        System.out.println("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
        extent_test_logger = extent_report.createTest(getTestMethodName(iTestResult));
        extent_test_logger.log(Status.INFO, getTestMethodName(iTestResult) + " STARTING");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
        extent_test_logger = extent_report.createTest(getTestMethodName(iTestResult));
        extent_test_logger.log(Status.PASS, getTestMethodName(iTestResult) + " PASSED");
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am in onTestFailure method " + iTestResult.getName() + " failed");
        extent_test_logger = extent_report.createTest(iTestResult.getName());
        extent_test_logger.log(Status.FAIL, iTestResult.getName() + " FAILED");
        String screenshot_attach_folder = "Screenshots/";
        String screenshot_save_folder = extent_html_report_path + screenshot_attach_folder;
        String screenshot_location = UI_Helper.getScreenshot(screenshot_save_folder, iTestResult.getName());
        String screenshot_attach_path = screenshot_attach_folder + screenshot_location.substring(screenshot_location.lastIndexOf("/", screenshot_location.length()) + 1);
        extent_test_logger.fail("Name of the failed test case: " + iTestResult.getName());

        try {
            extent_test_logger.addScreenCaptureFromPath(screenshot_attach_path);
            extent_test_logger.fail("Error message from the console: \n" + iTestResult.getThrowable());
            extent_test_logger.log(Status.FAIL, MarkupHelper.createLabel(iTestResult.getName() + " Test Case FAILED", ExtentColor.RED));
        } catch (IOException var7) {
        }

    }

    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
        extent_test_logger = extent_report.createTest(getTestMethodName(iTestResult));
        extent_test_logger.log(Status.SKIP, getTestMethodName(iTestResult) + " SKIPPED");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
        extent_test_logger = extent_report.createTest(getTestMethodName(iTestResult));
        extent_test_logger.log(Status.SKIP, getTestMethodName(iTestResult) + " FAILED  WITHIN SUCCESS RATIO");
    }
}
