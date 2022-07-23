package com.inetBanking.testCases;



import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	String userid = "mngr426948";
	String password="mAhUmab";
	String url="https://demo.guru99.com/V1/index.php";
	public static WebDriver driver;
	public static Logger logger;
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromiumdriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		logger=Logger.getLogger("eBanking");
		PropertyConfigurator.configure("Log4j.properties");
	}

}
