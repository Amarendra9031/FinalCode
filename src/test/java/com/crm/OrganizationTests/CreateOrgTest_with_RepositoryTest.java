package com.crm.OrganizationTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFieUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileutility;
import com.crm.GenericLibrary.WebdriverUtility;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.Organizationspage;

public class CreateOrgTest_with_RepositoryTest 
{
	@Test
	public void createOrgTest() throws Throwable
	{

		PropertyFileutility pLib=new PropertyFileutility();
		JavaUtility jLib=new JavaUtility();
		ExcelFieUtility eLib=new ExcelFieUtility();
		WebdriverUtility wLib=new WebdriverUtility();

		/*Step 1: read all neccessary data*/

		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL =  pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");

		String OrgName=eLib.readDataFromExcel("Org", 1, 2)+" "+jLib.getRandomNumber();

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
		CreateOrganizationPage cop =new CreateOrganizationPage(driver);
		cop.CreateOrganizationpage();

		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		/*Step 7: logout of application*/

		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseHover(driver, ele);
		/*Step 8: close the browser*/
		driver.quit();
	}
}
