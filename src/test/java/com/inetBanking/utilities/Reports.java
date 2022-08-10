package com.inetBanking.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports implements ITestListener {
	public void onStart(ITestContext context) {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
	}
	

}
