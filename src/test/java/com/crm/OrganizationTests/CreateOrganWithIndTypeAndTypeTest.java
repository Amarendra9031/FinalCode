package com.crm.OrganizationTests;

import java.io.IOException;

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
import com.crm.ObjectRepository.CreateOrganizationPage;
//import com.crm.ObjectRepository.CreateOrganizationpage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.Organizationspage;

public class CreateOrganWithIndTypeAndTypeTest
{

	//Create Obj for all utilities
	PropertyFileutility pLib = new PropertyFileutility();
	ExcelFieUtility eLib = new ExcelFieUtility();
	WebdriverUtility wLib = new WebdriverUtility();
	JavaUtility jLib= new JavaUtility();

	@Test(dataProvider = "getData")
	public void createOrganWithIndTypeAndTypeTest(String orgname,String indType,String type) throws Throwable
	{

		//read data 
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");

		String orgnameran =orgname +jLib.getRandomNumber();

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
		hp.ClickOnOrgLnk();
		Reporter.log("navigated to org link",true);

		//create Org
		Organizationspage op = new Organizationspage(driver);
		op.clickOnCreateOrgImg();
		Reporter.log("click on create org link",true);

		//create new org
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.CreateOrganizationpage();
		Reporter.log("create org with insustry type",true);

		//validate
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actHeader = oip.OrgNameInfo();
		if (actHeader.contains(orgnameran))
		{
			System.out.println("passed");
		}
		else
		{
			System.out.println("failed");
		}
		Reporter.log("verification successful",true);		

		//logout
		hp.signOutOfApp(driver);

		driver.quit();
	}

	@DataProvider
	public Object[][] getData() throws Throwable
	{
		Object[][] data = eLib.readmultipleDataFromExcel("OrgMultiPleData1");
		return data;
	}
}


