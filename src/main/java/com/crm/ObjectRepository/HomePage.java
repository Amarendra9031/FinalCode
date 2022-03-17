package com.crm.ObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebdriverUtility;

public class HomePage extends WebdriverUtility
{
	//Step 1 :declaration
	@FindBy(linkText = "Organizations")
	private WebElement organizationLinks;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(linkText="Opportunities")
	private WebElement OpportunitiesLnk;
	
	@FindBy(linkText="Products")
	private WebElement ProductsLnk;
	
	@FindBy(linkText="More")
	private WebElement MoreLnk;
	
	@FindBy(linkText="Campaigns")
	private WebElement CampaignsLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement  adminisrtaorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLnk;
	
	
	// Step 3: initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//step 3: generate Getters
	
	public WebElement getOrganizationlinks()
	{
		return organizationLinks;
	}

	public WebElement getContactsLnk()
	{
		return ContactsLnk;
	}
	
	public WebElement getOpportunitiesLnk() 
	{
		return OpportunitiesLnk;
	}

	public WebElement getProductsLnk() 
	{
		return ProductsLnk;
	}

	public WebElement getMoreLnk()
	{
		return MoreLnk;
	}

	public WebElement getCampaignsLnk() 
	{
		return CampaignsLnk;
	}

	public WebElement getAdminisrtaorImg()
	{
		return adminisrtaorImg;
	}

	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
	
	//Business Library
	public void ClickOnOrgLnk()
	{
		organizationLinks.click();
	}

	public void ClickContactsLnk()
	{
		 ContactsLnk.click();
	}
	public void signOutOfApp(WebDriver driver)
	{
		mouseHover(driver, adminisrtaorImg);
		signOutLnk.click();
	}
}
