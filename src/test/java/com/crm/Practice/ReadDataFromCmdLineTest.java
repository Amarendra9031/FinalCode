package com.crm.Practice;

import org.testng.annotations.Test;

public class ReadDataFromCmdLineTest
{
	@Test
	public void readDataFromCmdLine()
	{
		String BROWSER = System.getProperty("browser");
		String URL = System.getProperty("url");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");

		System.out.println("browser name is=========>"+BROWSER);
		System.out.println("url is=========>"+URL);
		System.out.println("username=========>"+USERNAME);
		System.out.println("password is=========>"+PASSWORD);
	}
}
