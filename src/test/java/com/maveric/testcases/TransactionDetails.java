package com.maveric.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.maveric.base.TestBase;
import com.maveric.utilities.TestUtil;

public class TransactionDetails extends TestBase {
	@Test
	public void transactionDetails() throws InterruptedException, IOException {
		driver.findElement(By.xpath(OR.getProperty("transaction_details"))).click();
		Thread.sleep(2000);
		WebElement selectElement = driver.findElement(By.xpath(OR.getProperty("transaction_account_no")));
		selectOption(selectElement,1);
		driver.findElement(By.xpath(OR.getProperty("transaction_date"))).sendKeys("07-21-2020");
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("find_transaction"))).click();
		Thread.sleep(2000);
		TestUtil.captureScreenshot();
		//driver.findElement(By.xpath(OR.getProperty("logOut"))).click();
		log.debug("Successfully captured transaction details");
		Reporter.log("Successfully captured transaction details");
		
		int cols = driver.findElements(By.xpath("//table[@id='transactionTable']/thead")).size();
		System.out.println(cols);
		
	}
}
