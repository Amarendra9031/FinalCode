package com.crm.OppertunityTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class CreateOpportunitywithAssignedtoGroupAsSupportGroupTest 
{
	@Test
	public void CreateOpportunitywithAssignedtoGroupAsSupportGroupTest() throws Throwable
	{

		/* Step 1: generate Random */

		Random ran= new Random();
		int random = ran.nextInt();

		/* Step 2 : Read data from External resource*/

		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommanData.Property");
		Properties pObj = new Properties();
		pObj.load(fis);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TestData.XLSX");
		Workbook wb= WorkbookFactory.create(fi);
		Sheet sheet = wb.getSheet("Oppertunity");
		Row rown = sheet.getRow(1);
		String optyNameRan = rown.getCell(2).getStringCellValue()+random;
		String expClosDate = rown.getCell(3).getStringCellValue();
		
		Sheet sheet2 = wb.getSheet("Contact");
		Row rown1 = sheet2.getRow(1);
		String orgNameRan = rown1.getCell(2).getStringCellValue()+random;
		


	}
}
