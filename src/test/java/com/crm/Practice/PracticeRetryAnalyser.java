package com.crm.Practice;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeRetryAnalyser 
{
	@Test(retryAnalyzer = com.crm.GenericLibrary.RetryAnalyserImplementation.class)
	public void practiceRetry()
	{
		System.out.println("Test1");
		//Assert.fail();
		System.out.println("passed");
	}
}
