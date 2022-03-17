package com.crm.GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	//Create Object of all Utilities

	public DataBaseUtility dbLib = new DataBaseUtility();
	public ExcelFieUtility eLib  = new ExcelFieUtility();
	public JavaUtility jLib = new JavaUtility();
	public PropertyFileutility pLib =  new PropertyFileutility();
	public WebdriverUtility wLib  = new WebdriverUtility();
	public WebDriver driver; 
	public static WebDriver sDriver;


	@BeforeSuite(groups = {"SmokeSuit","RegressionSuite"})
	public void connectDataBase()
	{
		//dbLib.connectToDb();
		System.out.println("===============Connect To Db==================");
	}


	@Parameters("browser")     //-----> Cross browser
	//@BeforeTest
	//@BeforeClass(groups = {"SmokeSuit","RegressionSuite"}) //-->Simple parallel execution, batch execution,Regression, smoke etc.
	//public void launchBrower(String BROWSER) throws Throwable //-----> cross browser give parameter
	public void launchBrower() throws Throwable //-----> cross browser give parameter

	{
		//Read data from property
		String BROWSER = pLib.readDataFromPropertyFile("browser"); //-------uncomment
		String URL= pLib.readDataFromPropertyFile("url");


		//Create runtime Polymorphism

		/*Step 2: launch the browser*/
		WebDriver driver=null;

		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else		

		{
			System.out.println("invalid browser");
		}


		sDriver=driver;

		wLib.maximizeWindow(driver);
		wLib.waitForpageLoad(driver);
		driver.get(URL);
		Reporter.log("===============browser launch successful======", true);
	}

	@BeforeMethod(groups = {"SmokeSuit","RegressionSuite"})
	public void login() throws Throwable
	{

		String USERNAME = pLib.readDataFromPropertyFile("user");
		String PASSWORD = pLib.readDataFromPropertyFile("password");

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		Reporter.log("======Login successful======", true);
	}

	@AfterMethod(groups = {"SmokeSuit","RegressionSuite"})
	public void logout()
	{
		HomePage hp = new HomePage(driver);
		hp.signOutOfApp(driver);
		Reporter.log("======Logout successful======", true);
	}

	//@AfterTest
	@AfterClass(groups = {"SmokeSuit","RegressionSuite"}) //---Simple Parallel execution

	// ----> //Distributed parallel execution remove parameter
	public void closeBrowser()
	{
		driver.quit();
		Reporter.log("======Browser close successful======", true);
	}

	@AfterSuite(groups = {"SmokeSuit","RegressionSuite"})
	public void CloseDb() throws Throwable
	{
		dbLib.closeDB();
		Reporter.log("======Database close successful======", true);
	}


}
