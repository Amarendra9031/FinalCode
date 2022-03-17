package com.crm.OppertunityTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CreateOpportunitywithAssignedtoGroupAsTeamSellingTest
{
	private static final CharSequence OppertunityRan = null;
	private static final String Oppertunity = null;

	@Test
		public void createOpportunitywithAssignedtoGroupAsTeamSelling() throws Throwable
		{

		/* Step 1: generate Random */

		Random ran= new Random();
		int random = ran.nextInt();

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
		String optyNameRan = rown.getCell(2).getStringCellValue()+random;
		String expClosDate = rown.getCell(3).getStringCellValue();
		
		Sheet sheet2 = wb.getSheet("Contact");
		Row rown1 = sheet2.getRow(1);
		String orgNameRan = rown1.getCell(2).getStringCellValue()+random;
		String OpportunityRan = Oppertunity+" "+random;
		

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
        
		
}
	
	
}
