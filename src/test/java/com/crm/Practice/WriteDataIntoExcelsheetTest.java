package com.crm.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class WriteDataIntoExcelsheetTest
{
	@Test
	public void writeDataIntoExcelsheet() throws Throwable
	{
		//step :1 open file in the mode
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Data.XLSX");
		//step :2 create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		//Step :3 get the sheet
		Sheet sh = wb.getSheet("Sheet1");
		//Step :4 get the row
		Row ro = sh.getRow(2);
		//Step : 5 create a cell to write new data
		Cell ce = ro.createCell(5);
		//Step : 6 set a cell value
		ce.setCellValue("tc_100");
		//open file in write mode
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\Data.XLSX");
		wb.write(fos);
	}
}

