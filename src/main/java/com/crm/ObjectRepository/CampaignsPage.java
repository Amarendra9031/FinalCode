package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage
{
	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement CreateProductLookUp;

	public CampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateProductLookUp()
	{
		return CreateProductLookUp;
	}

	//Business library

	public void clickOnNewCmpimg()
	{
		CreateProductLookUp.click();
	}
}
