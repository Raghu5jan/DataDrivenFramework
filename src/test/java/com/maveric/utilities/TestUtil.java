package com.maveric.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import com.maveric.base.TestBase;

public class TestUtil extends TestBase{
	public static String screenshotName;
	
	@DataProvider(name="dp")
	public Object[][] getData(Method m) {
		String sheetName = m.getName();
		// ParaBankRegistration
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		Object [][] data = new Object[rows-1][cols];
		
		
		for(int rowNum=2;rowNum<=rows;rowNum++) {
			for (int colNum =0;colNum<cols;colNum++) {
				data[rowNum -2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		
		return data;
		
	}
	
	/*public static void captureScreenShot(WebDriver driver) {
		Date d = new Date();
		
		String screenshotName = d.toString().replace(" ", "_");
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// now copy the screenshot to desired location using copyFile method

			FileUtils.copyFile(src, new File("./test-output/Screenshots/ElementsScreenshot" + screenshotName + ".png"));
		} catch (IOException e)

		{
			System.out.println(e.getMessage());
		}
	}*/
	public static void captureScreenshot() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\test-output\\html\\" + screenshotName));

	}
}


