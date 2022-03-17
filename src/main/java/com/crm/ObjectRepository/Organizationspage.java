package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebdriverUtility;

public class Organizationspage extends WebdriverUtility
{
	//step 1 : Declaration 
	
		@FindBy(xpath = "//img[@alt='Create Organization...']")
		private WebElement createOrgLookUpImg;
		
		//Step 2: initialization 
		
		public Organizationspage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			
		}
		//Step 3: Utilization
		
		public WebDriver getCreateOrgLookUpImg()
		{
			return getCreateOrgLookUpImg();
		}
		//Business Library
		
		public void clickOnCreateOrgImg()
		{
			createOrgLookUpImg.click();
		}
}
