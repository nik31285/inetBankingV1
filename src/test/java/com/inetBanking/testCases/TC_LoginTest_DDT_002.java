package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLReader;

public class TC_LoginTest_DDT_002 extends BaseClass {
	@Test(dataProvider = "LogInData")
	public void loginTestDDT(String userName, String password) {
		driver.get(url);
		LoginPage pl = new LoginPage(driver);
		pl.setUserID(userName);
		pl.setPassword(password);
		pl.clickLogin();
		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			Assert.assertTrue(false);
		}
		else {
			pl.clickLogout();
			driver.switchTo().alert().accept();
			Assert.assertTrue(true);
		}
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	@DataProvider(name = "LogInData")
	public String[][] getData() throws IOException {
		String filePath = "./src/test/java/com/inetBanking/testData/LoginData.xlsx";
		int rowNum = XLReader.getRowCount(filePath, "Sheet1");
		int coloumnNum = XLReader.getCellCount(filePath, "Sheet1", rowNum);
		System.out.println("Row=" + rowNum + "\nColoumn=" + coloumnNum);
		String[][] data = new String[rowNum][coloumnNum];
		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < coloumnNum; j++) {
				data[i][j] = XLReader.getCellData(filePath, "Sheet1", i + 1, j);
				System.out.print(data[i][j] + "    ");
			}
			System.out.println();
		}
		return data;
	}
}
