package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage 
{
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement CreateProductLookUp;

	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateProductLookUp()
	{
		return CreateProductLookUp;
	}

	//Business library

	public void clickOnProductimg()
	{
		CreateProductLookUp.click();
	}
}
