package com.crm.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadDataFromExcelSheetTest
{
	@Test
	public void readDataFromExcel() throws Throwable
	{
		//step :1 load excel file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Data.XLSX");
		//step :2 create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		//Step :3 get the sheet
		Sheet sh = wb.getSheet("Sheet1");
		//Step :4 get the row
		Row ro = sh.getRow(0);
		//Step : 5 get the cell
		Cell ce = ro.getCell(0);
		//Step : 6 read the data from the cell
		String value = ce.getStringCellValue();
		System.out.println(value);
	}
}
