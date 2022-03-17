package com.crm.OrganizationTests;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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

public class CreateOrgCooseIndustryTypeTest_Generic 
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
		String indType=eLib.readDataFromExcel("Org", 4, 3);

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

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		/*Step 4: Navigate to Organizations Link*/

		driver.findElement(By.linkText("Organizations")).click();																											

		/*Step 5: click on create organization btn*/

		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
																																																										
		/*Step 6: enter mandatory fields and save*/

		driver.findElement(By.name("accountname")).sendKeys(OrgName);
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
