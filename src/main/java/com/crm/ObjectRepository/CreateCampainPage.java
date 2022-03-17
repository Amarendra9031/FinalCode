package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebdriverUtility;

public class CreateCampainPage extends WebdriverUtility 
{
	@FindBy(name="campaignname")
	private WebElement CampaignNameEdt;

	@FindBy(xpath = "//input[@name='product_name']/following-sibling::img")
	private WebElement ProNameLookUpImg;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(name = "search_text")
	private WebElement searchEdt;

	@FindBy(name = "search")
	private WebElement searchBtn;

	public CreateCampainPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampaignNameEdt()
	{
		return CampaignNameEdt;
	}

	public WebElement getProNameLookUpImg()
	{
		return ProNameLookUpImg;
	}

	public WebElement getSaveBtn() 
	{
		return saveBtn;
	}

	public WebElement getSearchEdt() 
	{
		return searchEdt;
	}

	public WebElement getSearchBtn()
	{
		return searchBtn;
	}

	//Business language

	public void createNewCamp(String CampName,String ProName,WebDriver driver)
	{
		CampaignNameEdt.sendKeys(CampName);
		ProNameLookUpImg.click();

		switchToWindow(driver, "Products&action");
		searchEdt.sendKeys(ProName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ProName+"']")).click();
		switchToWindow(driver, "Campaigns&action");

		saveBtn.click();
	}
}
