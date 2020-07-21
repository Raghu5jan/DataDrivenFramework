package com.maveric.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.maveric.base.TestBase;
import com.maveric.utilities.TestUtil;

public class TransferAmount extends TestBase {
    @Test
	public void transferAmount() throws InterruptedException, IOException {
    	
    	driver.findElement(By.xpath(OR.getProperty("transfer_fund"))).click();
		Thread.sleep(2000);
    	driver.findElement(By.xpath(OR.getProperty("amount"))).sendKeys("200");
    	WebElement selectElement = driver.findElement(By.xpath(OR.getProperty("account_to")));
    	selectOption(selectElement,1);
		Thread.sleep(1000);
		driver.findElement(By.xpath(OR.getProperty("transfer_money_button"))).click();
		Thread.sleep(1000);
		TestUtil.captureScreenshot();
		String expectedMsg = "Transfer Complete!";
		String actualMsg = driver.findElement(By.xpath(OR.getProperty("transfer_complete_message"))).getText();
		Assert.assertEquals(actualMsg, expectedMsg);
	}
}