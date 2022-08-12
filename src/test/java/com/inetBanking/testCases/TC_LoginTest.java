package com.inetBanking.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest extends BaseClass {
	@Test
	public void loginTest() {
		driver.get(url);
		logger.info("URL is opened");
		LoginPage pl=new LoginPage(driver);
		pl.setUserID(userid);
		logger.info("Entered Username");
		pl.setPassword(password);
		logger.info("Entered Password");
		pl.clickLogin();
		logger.info("Clicked on login");	
		String Title=driver.getTitle();
		System.out.println(Title);
		Assert.assertTrue(Title.contains("GTPL Bank Manager HomePage"));	
	}
}
