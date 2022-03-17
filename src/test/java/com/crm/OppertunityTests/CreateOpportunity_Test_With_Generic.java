package com.crm.OppertunityTests;

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

public class CreateOpportunity_Test_With_Generic 
{
	@Test(groups="smokesuite")
	public void createOpportunityTestWithGeneric() throws Throwable
	{

		PropertyFileutility pLib=new PropertyFileutility();
		JavaUtility jLib= new JavaUtility();
		ExcelFieUtility eLib=new ExcelFieUtility();
		WebdriverUtility wLib= new WebdriverUtility();
		
		/* read all necessary data*/

		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD =  pLib.readDataFromPropertyFile("password");
		
		//read data from property file
		
		String ContactName = eLib.readDataFromExcel("Opportunities", 1, 4);
		String CampName = eLib.readDataFromExcel("Opportunities", 1, 5);
		String OppName = eLib.readDataFromExcel("Opportunities", 1, 1);
		String RepValue=eLib.readDataFromExcel("Opportunities", 1, 2);
		String Leadsrc=eLib.readDataFromExcel("Opportunities", 1, 3);



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

		/* STEP 4: Navigate to contacts link */

		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(ContactName);

		/* Step 5: Save the contacts*/
		
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		String conHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(conHeader.contains(ContactName))
		{
			System.out.println(conHeader);
			System.out.println("contact is created");
		}
		else
		{
			System.out.println(conHeader);
			System.out.println("contact is not created");
		}
		/*Step 6:Navigate to campaign link*/
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(CampName);
		driver.findElement(By.name("button")).click();

		String campignHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(campignHeader.contains(CampName))
		{
			System.out.println(campignHeader);
			System.out.println("campign is created");
		}
		else
		{
			System.out.println(campignHeader);
			System.out.println("campgn is not created");
		}

		//Step 7:Navigate to opportunities
		
		driver.findElement(By.linkText("Opportunities")).click();
		driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
		driver.findElement(By.name("potentialname")).sendKeys(OppName);
		WebElement ele = driver.findElement(By.id("related_to_type"));
		wLib.select(RepValue, ele);
		driver.findElement(By.xpath("//img[@style='cursor:hand;cursor:pointer']")).click();
		wLib.switchToWindow(driver, "Contacts");
		driver.findElement(By.id("search_txt")).sendKeys(ContactName);
		driver.findElement(By.name("search")).click();
		WebElement conNa = driver.findElement(By.xpath("//a[text()='"+" "+ContactName+"']"));
		wLib.waitForElementToBeClickable(driver, conNa);
		conNa.click();
		wLib.switchToWindow(driver, "Potentials");
		WebElement ele3 = driver.findElement(By.name("leadsource"));
		wLib.select(Leadsrc, ele3);
		driver.findElement(By.xpath("//input[@name='campaignname']/following-sibling::img[@title='Select']")).click();
		wLib.switchToWindow(driver, "Campaigns");
		driver.findElement(By.id("search_txt")).sendKeys(CampName);
		driver.findElement(By.name("search")).click();
		WebElement campNa = driver.findElement(By.xpath("//a[text()='"+CampName+"']"));
		wLib.waitForElementToBeClickable(driver, campNa);
		campNa.click();
		wLib.switchToWindow(driver, "Potentials");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String opporHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(opporHeader.contains(OppName))
		{
			System.out.println(opporHeader);
			System.out.println("opportunity is created");
		}
		else
		{
			System.out.println(opporHeader);
			System.out.println("opportunity is not created");
		}
		/*logout from the application*/
		
		WebElement ele4 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseHover(driver, ele4);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();

		/* close the application*/
		
		driver.quit();

	}
}
