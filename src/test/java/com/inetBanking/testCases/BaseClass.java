package com.inetBanking.testCases;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ReadConfig readconfig = new ReadConfig();
	String userid = readconfig.getUserId();
	String password = readconfig.getPassword();
	String url = readconfig.getURL();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("Browser")
	@BeforeClass
	public void setUp(String Br) {
		if (Br.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromiumdriver().setup();
			driver = new ChromeDriver();
		}
		else if(Br.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		logger = Logger.getLogger("eBanking");
		PropertyConfigurator.configure("Log4j.properties");
	}
	public static File capture() {
		File input=((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
		return input;
	}

}
