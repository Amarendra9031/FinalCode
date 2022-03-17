package com.crm.ContactTests;

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

public class CreateContactsTest_Generic 
{
	@Test
	public void createContacts() throws Throwable
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

		String lastName=eLib.readDataFromExcel("Org", 1, 2)+" "+jLib.getRandomNumber();

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
		//Step 3: login the app
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		/*Step 4: Navigate to Contact and create contact with mandatory fields Link*/

		driver.findElement(By.linkText("Contacts")).click();

		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		/*Step 7 : logout the application */
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseHover(driver, ele);
		driver.findElement(By.linkText("Sign Out")).click();

		driver.quit();

	}
}
