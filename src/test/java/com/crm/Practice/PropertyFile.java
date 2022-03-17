package com.crm.Practice;
import java.io.FileInputStream;
import java.util.Properties;
public class PropertyFile 
{
	public void propertyFile() throws Throwable
	{
		//Step 1: read the file
		FileInputStream fis = new FileInputStream(".\\src\\main\\resources\\commanData.properties");
		//Step 2: Create Obj of Properties
		Properties pObj = new Properties();
		pObj.load(fis);
		//Step 3:read the data
		String URL = pObj.getProperty("username");
		//Verification
		System.out.println(URL);
	}
}
