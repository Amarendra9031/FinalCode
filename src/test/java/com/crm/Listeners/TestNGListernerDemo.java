package com.crm.Listeners;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//@Listeners(com.crm.Listeners.TestNGListeners.class)
public class TestNGListernerDemo 
{
	@Test
	public void test1()
	{
		System.out.println(" i am inside test1");
	}
	@Test
	public void test2()
	{
		System.out.println(" i am inside test2");
		//Assert.assertTrue(false);
	}
	@Test
	public void test3()
	{
		System.out.println(" i am inside test3");
		//throw new SkipException("skipped");
	}
}
