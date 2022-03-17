package com.crm.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener
{

	public void onTestStart(ITestResult result) 
	{
		System.err.println(" ---- Test Started ---"+result.getName());
	}

	
	public void onTestSuccess(ITestResult result) 
	{
		System.err.println(" ---- Test is successful ---"+result.getName());
	}

	
	public void onTestFailure(ITestResult result)
	{
		System.err.println(" ---- Test is failed ---"+result.getName());
	}


	public void onTestSkipped(ITestResult result)
	{
		System.err.println(" ---- Test is skipped ---"+result.getName());
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}


	public void onTestFailedWithTimeout(ITestResult result)
	{
		
	}

	
	public void onStart(ITestContext context)
	{
		
	}

	
	public void onFinish(ITestContext context)
	{
		System.err.println(" ---- Test completed---"+context.getName());
	}

}
