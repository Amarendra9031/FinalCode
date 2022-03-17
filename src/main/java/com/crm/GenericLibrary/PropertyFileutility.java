package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This class will read data from property File and return the value to user 
 * @author Amarendra kumar
 *
 */
public class PropertyFileutility

{
	/**
	 * this method will read data from property file for the key value given by user
	 * and return value to user 
	 * @param key
	 * @return
	 * @throws Throwable 
	 */
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\CommanData.Property");
		Properties pLib = new Properties();
		pLib.load(fis);
		String value = pLib.getProperty(key);
		return value;
	}

}
