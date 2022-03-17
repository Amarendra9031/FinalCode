package com.crm.CampaignsTests;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateCampaignWithProductNameTest
{
	@Test
	public void createCampainWithProductName() throws Throwable
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
		Sheet sh = wb.getSheet("Campaigns");
		Row ro = sh.getRow(1);
		Cell cel = ro.getCell(3); 
		String ProductName = cel.getStringCellValue();
		String ProNameRan=ProductName+" "+random;

		Cell ce = ro.getCell(2);
		String campaignName = ce.getStringCellValue()+random;


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

		/*Step 4: Navigate to Product Link*/
		driver.findElement(By.linkText("Products")).click();

		/*Step 5: click on create organization btn*/
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();

		/*Step 6: enter mandatory fields and save*/
		driver.findElement(By.name("productname")).sendKeys(ProNameRan);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		/*Step 7:verify for organization*/
		String header = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(header.contains(ProNameRan))
		{
			System.out.println(header);
			System.out.println("org created");
		}
		else
		{
			System.out.println(header);
			System.out.println("Org not created");
		}

		/*step 8: navigate to compaign link*/
		driver.findElement(By.xpath("//img[@src='themes/softed/images/layerPopupBg.gif']")).click();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@src=themes/softed/images/btnL3Add.gif]")).click();
		driver.findElement(By.name("campaignname")).sendKeys(campaignName);

		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();

		/*Step 9: choose org */
		Set<String> win = driver.getWindowHandles();
		for(String winId:win)
		{
			driver.switchTo().window(winId);
		}

		driver.findElement(By.name("search_text")).sendKeys(ProNameRan);
		driver.findElement(By.name("search")).click();

		driver.findElement(By.xpath("//a[text()='"+ProNameRan+"']")).click();

		Set<String> win1 = driver.getWindowHandles();
		for(String wi : win1)
		{
			driver.switchTo().window(wi);
		}

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		/*Step 10: verify for contact*/
		String contactHeader1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(contactHeader1.contains(campaignName))
		{
			System.out.println(contactHeader1 +" campaign created");
		}
		else
		{
			System.out.println("contact not created");
		}

		/*Step 11: logout and close the browser*/
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();

		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}	
}
