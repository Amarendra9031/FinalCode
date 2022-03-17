package com.crm.Practice;

import org.testng.annotations.Test;

public class PracticeTestNG 
{

	@Test(priority = 1)
	public void createOrg()
	{
		System.out.println("org created");
	}


	@Test(priority = 3)
	public void modifyOrg()
	{
		System.out.println("org modified");
	}


	@Test(priority = 2)
	public void deleteOrg()
	{
		System.out.println("org deleted");
	}
}

