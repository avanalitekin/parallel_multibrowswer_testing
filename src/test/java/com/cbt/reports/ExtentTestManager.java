package com.cbt.reports;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentTestManager {
    public static ExtentHtmlReporter html_reporter;
    public static ExtentReports extent_report;
    public static ExtentTest extent_test_logger;
    protected static String extent_html_report_path = "extent_report/";
    private static String extent_html_report_name = "extent_report.html";

    public ExtentTestManager() {
    }

    static {
        if (extent_report == null) {
            extent_report = new ExtentReports();
        }

        if (html_reporter == null) {
            html_reporter = new ExtentHtmlReporter(extent_html_report_path + extent_html_report_name);
            extent_report.attachReporter(new ExtentReporter[]{html_reporter});
        }

    }
}
