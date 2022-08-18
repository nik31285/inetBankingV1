package com.inetBanking.testCases;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	@Test
	public void addNewCustomer() throws InterruptedException {
		driver.get(url);
		LoginPage lp = new LoginPage(driver);
		lp.setUserID(userid);
		lp.setPassword(password);
		lp.clickLogin();

		

		AddCustomerPage ac = new AddCustomerPage(driver);
		
		ac.clickNewCustomer();
		Thread.sleep(3000);
		ac.clickOnClose();
		
//		driver.switchTo().frame(1);
		System.out.println("Hello");
//		driver.findElement(By.xpath("//div[@id=\"dismiss-button\"]")).click();
		System.out.println("Hello");
		ac.custgender("female");
	}

	
}
