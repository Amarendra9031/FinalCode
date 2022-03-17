package com.crm.ContactTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFieUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileutility;
import com.crm.GenericLibrary.WebdriverUtility;
import com.crm.ObjectRepository.CreateContactInfoPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.Organizationspage;

public class CreateContactWithMandatoryTest 
{
	//Create Obj for all utilities
	PropertyFileutility pLib = new PropertyFileutility();
	ExcelFieUtility eLib = new ExcelFieUtility();
	WebdriverUtility wLib = new WebdriverUtility();
	JavaUtility jLib = new JavaUtility();

	@Test(dataProvider = "getData")
	public void createOrgWithMltipleData(String lastName) throws Throwable
	{


		//read data 
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
  
		String lastname = lastName;

		//launch the application
		WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("FIREFOX"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}

		wLib.maximizeWindow(driver);
		wLib.waitForpageLoad(driver);
		driver.get(URL);

		//login to application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		Reporter.log("login successful",true);

		//navigate to organization
		HomePage hp = new HomePage(driver);
		hp.ClickContactsLnk();
		Reporter.log("click on Contacts",true);

		//create contact
		CreateContactPage cp=new CreateContactPage(driver);
		cp.getOrgNameLookUpImg();
		Reporter.log("click on create org link",true);
		
		//create new contact
		
	     CreateContactPage ccp=new CreateContactPage(driver);
	     ccp.createNewContact(lastname);
	     Reporter.log("create contact",true);
	     

		//validate
	     CreateContactInfoPage cip=new CreateContactInfoPage(driver);
	     String hdr = cip.CreateNameInfo();
	
	     if(hdr.contains(lastname))
	     {
	    	 Reporter.log("verification successful",true);		

	     }
	     else 
		{
	    	 Reporter.log("verification is not successful",true);		

		}
		//logout
		hp.signOutOfApp(driver);

		driver.quit();
	}

	@DataProvider
	public Object[][] getData() throws Throwable
	{
		Object[][] data = eLib.readmultipleDataFromExcel("Contacts");
		return data;
	}

}

