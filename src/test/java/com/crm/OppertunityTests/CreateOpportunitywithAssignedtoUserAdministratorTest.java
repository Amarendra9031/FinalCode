package com.crm.OppertunityTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class CreateOpportunitywithAssignedtoUserAdministratorTest 
{

	@Test
	public void createOpportunitywithAssignedtoUserAdministratorTest () throws Throwable, IOException
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

		/* read data from excel file*/
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TestData.XLSX");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Opportunities");
		Row ro = sh.getRow(1);
		Cell cel = ro.getCell(4);
		String Opportunity = cel.getStringCellValue();
		String OpportunityRan = Opportunity+" "+random;

		Cell ce = ro.getCell(3);
		String Organization = ce.getStringCellValue();
	}
}
