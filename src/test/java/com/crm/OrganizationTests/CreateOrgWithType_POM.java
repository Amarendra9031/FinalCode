package com.crm.OrganizationTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

public class CreateOrgWithType_POM
{
	@Test
	public void createOrgWithType() throws Throwable
	{

		PropertyFileutility pLib=new PropertyFileutility();
		JavaUtility jLib= new JavaUtility();
		ExcelFieUtility eLib=new ExcelFieUtility();
		WebdriverUtility wLib= new WebdriverUtility();


		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");

		String OrgName = eLib.readDataFromExcel("Org", 1, 2)+jLib.getRandomNumber();
		String IndType = eLib.readDataFromExcel("Org", 1, 3);
		String Type = eLib.readDataFromExcel("Org", 1, 4);

		WebDriver driver =(null);
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
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

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);


		HomePage hp = new HomePage(driver);
		hp.ClickOnOrgLnk();

		Organizationspage op = new Organizationspage(driver);
		op.clickOnCreateOrgImg();

		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.CreateOrganizationpage(OrgName,IndType,Type);

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actData = oip.OrgNameInfo();
		if (actData.contains(OrgName))
		{
			System.out.println(actData+" "+"actData is verified");
		}
		else
		{
			System.out.println("Data is verified");
		}

		hp.signOutOfApp(driver);

		driver.quit();

	}
}
