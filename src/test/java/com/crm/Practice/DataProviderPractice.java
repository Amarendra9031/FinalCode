package com.crm.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice 
{
	@Test(dataProvider="getData")
	public void sampleDataProvider(String Name,String model,int qty)
	{
		System.out.println(Name+"-----"+model+"----"+qty);
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj=new Object[4][3];

		obj[0][0]="MI";
		obj[0][1]="13 Pro max";
		obj[0][2]=20;

		obj[1][0]="Vivo";
		obj[1][1]="12 pro";
		obj[1][2]=10;

		obj[2][0]="Samsung";
		obj[2][1]="Samsung glaxay j7 max";
		obj[2][2]=30;

		obj[3][0]="Realme";
		obj[3][1]="9 pro";
		obj[3][2]=25;
		return obj;
	}
}
