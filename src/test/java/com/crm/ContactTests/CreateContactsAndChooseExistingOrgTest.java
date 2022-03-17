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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CreateContactsAndChooseExistingOrgTest
{

	@Test
	public void createContactsWithAnyOrgTest() throws Throwable
	{
		//generate random number
		Random ran=new Random();
		int random = ran.nextInt(500);
				
		//Step1: read data from property file and excel sheets
		//Property file for common data
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties obj=new Properties();
		obj.load(fis);
		String BROWSER = obj.getProperty("browser");
		String URL = obj.getProperty("url");
		String USERNAME = obj.getProperty("username");
		String PASSWORD = obj.getProperty("password");
				
		//Excel sheets for test data
		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet s = wb.getSheet("Contacts");
		Row r = s.getRow(4);
		Cell c = r.getCell(2);
		Cell ce = r.getCell(3);
		String LastName = c.getStringCellValue();
		String OrgName = ce.getStringCellValue();
				
		//launch browser
		WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else 
		{
			System.out.println("invalid case");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
				
		//step2: login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
				
		//step3: click on organizations link
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				
		//step4: fill mandatory fields
		driver.findElement(By.name("lastname")).sendKeys(LastName+" "+random);
		Thread.sleep(5000);
				
		//fill org name
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		Thread.sleep(2000);
		//String pid = driver.getWindowHandle();
		//Set<String> alid = driver.getWindowHandles();
		//for (String childid : alid) 
		//{
		//driver.switchTo().window(childid);
		//driver.findElement(By.linkText("Xylem")).click();
		//Thread.sleep(2000);
		driver.findElement(By.name("account_name")).sendKeys(OrgName);
		//driver.findElement(By.id("1")).click();
		Thread.sleep(5000);
		//}
		//step5: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
				
		//step6: logout
		/*WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(ele));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();*/
				
		//step7: close
		driver.close();
				
	}
}
