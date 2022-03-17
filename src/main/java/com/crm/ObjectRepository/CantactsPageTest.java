package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CantactsPageTest
{
	//declaration
	
	@FindBy(xpath="//img[@alt='Create 078 Contact...']")
	private WebElement createContactLookUpImg;
	
	//initialization
	
	public void contactsPage(WebDriver driver)
	{
PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getCreateContactLookUpImg()
	{
		return createContactLookUpImg;
	}
	//business library
	public void clickOnCreateContactImg()
	{
		createContactLookUpImg.click();
	}
}
