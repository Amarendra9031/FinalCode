package com.crm.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFieUtility;

public class DataProviderWithExcel 
{
@Test (dataProvider = "data")
	
	public void data(String orgname,String indType,String Type)
	{
		System.out.println(orgname+" "+indType+" "+Type);
	}
	
	@DataProvider(name = "data")
	public Object[][] getData() throws Throwable 
	{
		ExcelFieUtility eLib = new ExcelFieUtility();
		Object[][] value = eLib.readmultipleDataFromExcel("OrgMultiPleData");
		return value;
	}
}
