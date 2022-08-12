package com.inetBanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;
import com.inetBanking.testCases.BaseClass;

public class ExtentReport implements ITestListener{
	ExtentReports extent;
	ExtentSparkReporter sparkReporter;
	public ExtentTest test;

	public void onStart(ITestContext context) {
		extent=new ExtentReports();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName = "Test-Report-" + timeStamp + ".html";
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/" + reportName);
		// sparkReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		try {
			sparkReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Envoirnment","QA");
		extent.setSystemInfo("user", "Nishikant");	
		sparkReporter.config().setDocumentTitle("InternetBanking Test Report");
		sparkReporter.config().setReportName("Functional Test Report");
		sparkReporter.config().setTheme(Theme.DARK);
	}
	public void onTestSuccess(ITestResult tr) {
		test=extent.createTest(tr.getName());
		test.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
	}
	public void onTestFailure(ITestResult tr) {
		test=extent.createTest(tr.getName());
		test.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		String screenShotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".jpeg";
		
	//	System.out.println(screenShotPath);
		File output=new File(screenShotPath);
		File input=BaseClass.capture();
		try {
			Files.copy(input, output);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		if(output.exists()){
			test.fail("Screenshot is below"+test.addScreenCaptureFromPath(screenShotPath));
		}
	}
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
