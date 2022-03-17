package com.crm.ContactTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;

@Listeners(com.crm.GenericLibrary.ListerImplementationClass.class)
public class CreateContactsTest_BaseClass extends BaseClass
{
	@Test(retryAnalyzer = com.crm.GenericLibrary.RetryAnalyserImplementation.class)
	public void createContactsTest() throws Throwable
	{
     String lastName = eLib.readDataFromExcel("Contacts", 1, 2)+" - "+jLib.getRandomNumber();
     HomePage hp=new HomePage(driver);
     hp.ClickOnOrgLnk();
     Assert.fail();
     
     //CreateContactPage.cp=new CreateContactPage(driver);
     
	}
}
