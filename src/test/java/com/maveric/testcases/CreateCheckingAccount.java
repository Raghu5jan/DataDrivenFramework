package com.maveric.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.maveric.base.TestBase;
import com.maveric.utilities.TestUtil;

public class CreateCheckingAccount extends TestBase {
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void createCheckingAccount(String userName, String passWord) throws InterruptedException, IOException {
		driver.findElement(By.xpath(OR.getProperty("usernameLogin"))).sendKeys(userName);
		driver.findElement(By.xpath(OR.getProperty("passwordLogin"))).sendKeys(passWord);
		driver.findElement(By.xpath(OR.getProperty("logIn"))).click();
		driver.findElement(By.xpath(OR.getProperty("open_new_account_link"))).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(OR.getProperty("open_new_account_button"))).click();
		Thread.sleep(2000);
		TestUtil.captureScreenshot();
		log.debug("Checking Account created");
		Reporter.log("Checking Account created");
		

	}
}
