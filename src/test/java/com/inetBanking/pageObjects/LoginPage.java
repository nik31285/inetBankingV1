package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
//	WebDriver ldriver;
//	
//	LoginPage(WebDriver rdriver){
//		this.ldriver=rdriver;
//	}
	
	@FindBy(css ="input[type=\"text\"]")
	WebElement txtUserID;
	
	@FindBy(css="input[type=password]")
	WebElement txtPassword;
	
	@FindBy(css="input[type=\"submit\"]")
	WebElement btnLogin;
	
	@FindBy(css="input[type=\"reset\"]")
	WebElement btnReset;
	
	public void setUserID(String UserID) {
		System.out.println("Hi");
		txtUserID.sendKeys(UserID);
	}
	
	public void setPassword(String Password) {
		txtPassword.sendKeys(Password);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickReset() {
		btnReset.click();
	}
}
