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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CreateOrgChooseIndustryTypeTest 
{
	@Test
	public void createOrgTest() throws Throwable
	{
		/*generate random number*/

		Random ran = new Random();
		int random = ran.nextInt(500);

		/*Step 1: read all necessary data*/

		//read data from property file

		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommanData.Property");
		Properties pObj = new Properties();
		pObj.load(fis);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");

		//read data from excel sheet

		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TestData.XLSX");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Org");
		Row ro = sh.getRow(4);
		Cell cel = ro.getCell(2);
		String OrgName = cel.getStringCellValue();
		Cell ce = ro.getCell(3);
		String indType = ce.getStringCellValue();

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

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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

		driver.findElement(By.name("accountname")).sendKeys(OrgName+" "+random);

		/*Step 7: logout of application*/

		driver.findElement(By.xpath("//select[@name='industry']")).sendKeys(indType);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}
}


