package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains generic methods to read and write data into excel sheet
 * @author Amarendra kumar
 *
 */
public class ExcelFieUtility
{
	/**
	 * This method will read data from excel sheet and return the value when sheetname
	 * row no and cell number is specified
	 * @return 
	 * @throws Throwable
	 */
	public String readDataFromExcel(String SheetName , int rowNo,int cellNo) throws Throwable
	{
		FileInputStream fis =new FileInputStream(IpathConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(SheetName);
		Row ro=sh.getRow(rowNo);
		Cell cel=ro.getCell(cellNo);
		String value = cel.getStringCellValue();
		return value;
	}
	/**
	 * This method will write data into excel sheet
	 * @param SheetName
	 * @param rowNo
	 * @param cellNo
	 * @param value
	 * @throws Throwable
	 */
	public void writeDataIntoExcel(String SheetName,int rowNo,int cellNo,String value) throws Throwable
	{

		FileInputStream fis =new FileInputStream(IpathConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(SheetName);
		Row ro=sh.getRow(rowNo);
		Cell cel=ro.createCell(cellNo);
		cel.setCellValue(value);
		FileOutputStream fos =new FileOutputStream(IpathConstants.Excelpath);
		wb.write(fos);

	}
	/**
	 * This method will return last row number
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String SheetName) throws Throwable
	{
		FileInputStream fis =new FileInputStream(IpathConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(SheetName);
		int row=sh.getLastRowNum();
		return row;
	}
	/**
	 * This method will read multiple data from excel sheet with the help of sheetname
	 * and return 2 dimensional object [][]
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public Object[][] readmultipleDataFromExcel(String SheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IpathConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCell];
		
		for(int i = 0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;
	
	}

}






