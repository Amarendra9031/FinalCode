package com.crm.ContactTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFieUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileutility;
import com.crm.GenericLibrary.WebdriverUtility;

public class CreateContactsAndChooseExistingOrgTest_Generic
{
	@Test
	public void createContactsWithAnyOrgTest() throws Throwable
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
		driver.findElement(By.name("lastname")).sendKeys(lastName);
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
		driver.findElement(By.name("account_name")).sendKeys(lastName);
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
