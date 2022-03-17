package com.crm.Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseClassPractice 
{
	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("database connectivity Established");
	}
	@BeforeMethod
	public void bmConfig()
	{
		System.out.println("login to app");
	}
	
	@Test
	public void actualTest()
	{
		System.err.println("test_script-1");
	}
	@AfterMethod
	public void amConfig()
	{
		System.err.println("logout of app");
		
	}
	@AfterClass
	public void acConfig()
	{
		System.err.println("close browser");
	}
	@BeforeClass
	public void  bcConfig()
	{
		System.out.println("launch the browser");
	}
	@AfterSuite
	public void asConfig()
	{
		System.out.println("close db");
	}
	
}
