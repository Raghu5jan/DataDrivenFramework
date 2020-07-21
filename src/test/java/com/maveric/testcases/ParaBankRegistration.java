package com.maveric.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.maveric.base.TestBase;
import com.maveric.utilities.TestUtil;

public class ParaBankRegistration extends TestBase {
	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void registerinsideParaBank(String firstName, String lastName, String address, String city, String state,
			String zipCode, String phone, String ssn, String userName, String password, String confirmPassword)
			throws InterruptedException, IOException {

		log.debug("Inside parabank registration form");
		driver.findElement(By.xpath(OR.getProperty("firstName"))).sendKeys(firstName);
		driver.findElement(By.xpath(OR.getProperty("lastName"))).sendKeys(lastName);
		driver.findElement(By.xpath(OR.getProperty("address"))).sendKeys(address);
		driver.findElement(By.xpath(OR.getProperty("city"))).sendKeys(city);
		driver.findElement(By.xpath(OR.getProperty("state"))).sendKeys(state);
		driver.findElement(By.xpath(OR.getProperty("zipcode"))).sendKeys(zipCode);
		driver.findElement(By.xpath(OR.getProperty("phoneNumber"))).sendKeys(phone);
		driver.findElement(By.xpath(OR.getProperty("ssnNumber"))).sendKeys(ssn);
		driver.findElement(By.xpath(OR.getProperty("userName"))).sendKeys(userName);
		driver.findElement(By.xpath(OR.getProperty("password"))).sendKeys(password);

		driver.findElement(By.xpath(OR.getProperty("confirmPassword"))).sendKeys(confirmPassword);
		driver.findElement(By.xpath(OR.getProperty("registerButton"))).click();
		Thread.sleep(2000);
		TestUtil.captureScreenshot();
		String expectedMsg = "Your account was created successfully. You are now logged in.";
	    String actualMsg = driver.findElement(By.xpath(OR.getProperty("expectedMsg"))).getText();
		Assert.assertEquals(actualMsg, expectedMsg);
		log.debug("Regisration done successfully");
		Reporter.log("Registration done successfully");
		driver.findElement(By.xpath(OR.getProperty("logOut"))).click();
		log.debug("Logout Successfully");
	}

}
