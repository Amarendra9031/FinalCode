package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInfoPage 
{
	//Step 1:declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerText;

	//Step 2:initialization
	public CampaignInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Step 3: utilization
	public WebElement getHeaderText()
	{
		return headerText;
	}

	//business library

	public String ContactNameInfo()
	{
		String CampInfo = headerText.getText();
		return CampInfo;
	}







}
