package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactInfoPage
{
	//Step 1: declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	//Step 2: initialization 
	public CreateContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//step 3: Utilization
	public WebElement getHeaderText()
	{
		return headerText;
	}
	
	//Business library
	public String CreateNameInfo()
	{
		String CreateInfo = headerText.getText();
		return CreateInfo;
		
	}
}
