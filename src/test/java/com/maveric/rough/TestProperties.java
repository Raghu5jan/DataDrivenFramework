package com.maveric.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class TestProperties {

	public static void main(String[]args) throws IOException, FilloException {
		
//		System.out.println(System.getProperty("user.dir"));
//		Properties config = new Properties();
//		Properties OR = new Properties();
//		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
//		config.load(fis);
//		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
//		OR.load(fis);
//		System.out.println(config.getProperty("browser"));
//		System.out.println(OR.getProperty("firstName"));
		Fillo fe = new Fillo();
		Connection connection = fe.getConnection(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\filloTestData.xlsx");
//		//F:\AbstractPrj\Java Project\DataDrivenFramework\src\test\resources\excel\filloTestData.xlsx
//		String strQuery = "Update FilloUsage Set Phone Number=9699810653 where First Name='ramesh'";
//		connection.executeUpdate(strQuery);
//		connection.close();
		
		 String strQuery1="Select * from FilloUsage where First Name='ramesh'";
		 Recordset recordset=connection.executeQuery(strQuery1);

		  while(recordset.next()){
		  System.out.println(recordset.getField("Last Name"));
		 }

		  recordset.close();
		 connection.close();
		}
	}

