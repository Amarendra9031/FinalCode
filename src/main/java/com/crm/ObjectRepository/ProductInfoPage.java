package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage 
{
	//Step 1: declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	//Step 2: initialization 
	public ProductInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//step 3: Utilization
	public WebElement getHeaderText()
	{
		return headerText;
	}
	
	//Business library
	public String ProductNameInfo()
	{
		String ProductInfo = headerText.getText();
		return ProductInfo;
	}
}
