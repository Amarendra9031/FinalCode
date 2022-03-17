package com.crm.OrganizationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFieUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileutility;
import com.crm.GenericLibrary.WebdriverUtility;
import com.crm.ObjectRepository.CreateOrganizationPage;
//import com.crm.ObjectRepository.CreateOrganizationpage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.Organizationspage;



public class CreateOrgCooseIndustryType_BaseClass_Test
{
	@Test
	public void createOrgCooseIndustryTypeTest() throws Throwable
	{
		PropertyFileutility pLib=new PropertyFileutility();
		JavaUtility jLib=new JavaUtility();
		ExcelFieUtility eLib=new ExcelFieUtility();
		WebdriverUtility wLib=new WebdriverUtility();
		/*Step 1: read all necessary data*/
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL =  pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");

		String OrgName=eLib.readDataFromExcel("Org", 1, 2)+" "+jLib.getRandomNumber();
		String indType=eLib.readDataFromExcel("Org", 1, 3);

		/*Step 2: launch the browser*/

		WebDriver driver=null;
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
		/*Step 3: login to application*/
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);


		/*Step 4: Navigate to Organizations Link*/

		HomePage hp=new HomePage(driver);
		hp.ClickOnOrgLnk();

		/*Step 5: click on create organization btn*/

		Organizationspage op=new Organizationspage(driver);
		op.clickOnCreateOrgImg();

		/*Step 6: enter mandatory fields and save*/
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);

		//Step 7: select industry type from dropdown
		WebElement ele=driver.findElement(By.name("industry"));
		wLib.select(indType, ele);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseHover(driver, ele);

		/*Step 8: logout of application*/
		//driver.findElement(By.linkText("Sign Out")).click();
		//close the browser
		driver.close();
	}
}


