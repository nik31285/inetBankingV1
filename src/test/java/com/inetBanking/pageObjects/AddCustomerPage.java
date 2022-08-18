package com.inetBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.inetBanking.testCases.BaseClass;

public class AddCustomerPage extends BaseClass {
	WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver,this);
	}
	
	@FindBy(css = "a[href=\"addcustomerpage.php\"]")
	WebElement newCustomer;
	
	@FindBy (css="input[name='name']")
	WebElement customerName;
	
	@FindBy(xpath = "(//input[@name=\"rad1\"])[1]")
	WebElement maleRadiobtn;
	
	@FindBy(xpath = "(//input[@name=\"rad1\"])[2]")
	WebElement femaleRadiobtn;
	
	@FindBy(how = How.NAME, using = "rad1")
	WebElement rdgender;
	
	@FindBy(css = "div#dismiss-button")
	WebElement closeAdd;
	
	public void custgender(String cgender) {
		if(cgender.equalsIgnoreCase("male"))
		maleRadiobtn.click();
		else
		femaleRadiobtn.click();	
	}
	public void clickNewCustomer() {
		newCustomer.click();
	}
	public void clickOnClose() {
		System.out.println("Inside close");
		//WebElement e= driver.findElement(By.cssSelector("iframe#ad_iframe"));
		driver.switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0");
		driver.switchTo().frame("ad_iframe");
		System.out.println("Inside frame");
		closeAdd.click();
		driver.switchTo().defaultContent();
	}
}
