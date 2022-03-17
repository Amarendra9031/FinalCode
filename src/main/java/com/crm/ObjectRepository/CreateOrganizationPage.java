package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFieUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileutility;
import com.crm.GenericLibrary.WebdriverUtility;


	public class CreateOrganizationPage extends WebdriverUtility
	{
	
			@FindBy(name="accountname")
			private WebElement orgNameEdit;
			
			@FindBy(name="industry")
			private WebElement indtryDropDown;
			
			@FindBy(name="accounttype")
			private WebElement typeDropDown;
			
			@FindBy(xpath = "//input[@title='Save [Alt+S]']")
			private WebElement saveBTN;
			
			
			public CreateOrganizationPage(WebDriver driver)
			{
				
				PageFactory.initElements(driver, this);
			}

			public WebElement getOrgNameEdit() {
				return orgNameEdit;
			}

			public WebElement getIndtryDropDown() {
				return indtryDropDown;
			}

			public WebElement getTypeDropDown() {
				return typeDropDown;
			}
			
			public WebElement getSaveBTN() {
				return saveBTN;
			}

			/**
			 * below are overloaded methods(createNewOrganiza) one to create organization with only orgName and another one with orgName and indType
			 */
			public void CreateOrganizationpage()
			{
				CharSequence orgName = null;
				orgNameEdit.sendKeys(orgName);
				saveBTN.click();
			}
			/**
			 *  below are overloaded methods(createNewOrganiza) one to create organization with orgName and indType
			 * @param orgName
			 * @param indType
			 */
			public void CreateOrganizationpage (String orgName,String indType)
			{
				orgNameEdit.sendKeys(orgName);
				select(indType,indtryDropDown);
				saveBTN.click();
			}
		/**
		 * below are overloaded methods(createNewOrganiza) one to create organization with organization name, Industy type and type
		 * @param orgName
		 * @param indType
		 * @param typeName
		 */
			public void CreateOrganizationpage (String orgName,String indType,String typeName)
			{
				orgNameEdit.sendKeys(orgName);
				select(indType,indtryDropDown);
				select(typeName, typeDropDown);
				saveBTN.click();
			}

		
		}
	
	


