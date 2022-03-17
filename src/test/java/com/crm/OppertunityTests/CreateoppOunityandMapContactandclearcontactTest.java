package com.crm.OppertunityTests;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CreateoppOunityandMapContactandclearcontactTest
{
	@Test
	public void createopportunityandMapContactandclearcontact() throws Throwable
	{
		/* Step 1: generate Random */

		Random ran= new Random();
		int random = ran.nextInt(400);

		/* Step 2 : Read data from External resource*/

		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommanData.Property");
		Properties pObj = new Properties();
		pObj.load(fis);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");

		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TestData.XLSX");
		Workbook wb= WorkbookFactory.create(fi);
		Sheet sheet = wb.getSheet("Oppertunity");
		Row rown = sheet.getRow(1);
		Cell cl = rown.getCell(5);
		String Oppertunity = cl.getStringCellValue();
		String OppertunityRan=Oppertunity+" "+random;
		
		Cell ce = rown.getCell(4);
		String Organization=ce.getStringCellValue();

		/* step 3 : Launch Browser*/

		WebDriver driver= null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid Broswer");
		}

		/* step 4: Login to application*/
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
	
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Potentials&action=index']")).click();
		driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
		driver.findElement(By.name("potentialname")).sendKeys(OppertunityRan);
		driver.findElement(By.xpath("//img[@alt='Select']")).click();

		/* Step 5: Create organization*/
		
		Set<String> win1 = driver.getWindowHandles();
		for(String wn1:win1)
		{
			driver.switchTo().window(wn1);


		}
		driver.findElement(By.name("search_text")).sendKeys(OppertunityRan);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+OppertunityRan+"']")).click();

		Set<String> win2 = driver.getWindowHandles();	
		for(String wn2:win2)
		{
			driver.switchTo().window(wn2);

		}
		//iver.findElement(By.xpath("");

		/* step 9 : Logout From Applition */
		driver.quit();

	}
}


