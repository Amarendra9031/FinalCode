package com.crm.Practice;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileutility;

public class PracticeForGenericUtils 
{
@Test
public void practice() throws Throwable
{
	JavaUtility jLib=new JavaUtility();
	int ran=jLib.getRandomNumber();
	String dat = jLib.getSystemDateInFormat();
	String date =jLib.getSystemDate();
	System.out.println(ran + date);
	System.out.println(dat);
	
	PropertyFileutility pLib=new PropertyFileutility();
	String BROWSER=pLib.readDataFromPropertyFile("browser");
	System.out.println(BROWSER);
}
}
