package com.crm.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice_1_Test 
{
	@Test(dataProvider="getData")
	public void sampleDataProvider(String SubjectName,int price)
	{
		System.out.println(SubjectName+"----"+price);
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj=new Object[6][2];

		obj[0][0]="Hindi";
		obj[0][1]=299;
		

		obj[1][0]="Math";
		obj[1][1]=199;
	
		obj[2][0]="English";
		obj[2][1]=399;
	

		obj[3][0]="Sanskrit";
		obj[3][1]=99;
		

		obj[4][0]="History";
		obj[4][1]=79;
		

		obj[5][0]="Geography";
		obj[5][1]=189;
		
		return obj;
	}
}
