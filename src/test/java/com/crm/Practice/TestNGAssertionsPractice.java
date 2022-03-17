package com.crm.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsPractice 
{
	@Test
	public void assertionPractice()
	{
		System.out.println("this is test-1");
		if(1==1)
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("failed");	
		}
		//Assert.assertEquals(1,1);
		//System.out.println("passed");
	}
}
