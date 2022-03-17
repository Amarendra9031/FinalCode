package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebdriverUtility;

public class CreateContactPage extends WebdriverUtility
{
	@FindBy(name ="lastname")
	private WebElement lastNameEdt;

	@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@alt='Select']")
	private WebElement orgNameLookUpImg;

	@FindBy(name="leadsource")
	private WebElement leadSourceDropDown;

	@FindBy(xpath="//input[@title ='save [Alt+s]']")
	private WebElement saveBtn;

	@FindBy(name="search_text")
	private WebElement searchEdt;

	@FindBy(name ="search")
	private WebElement searchBtn;

	private String orgName;

	//initialization 
	public  CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//utilization
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getOrgNameLookUpImg() {
		return orgNameLookUpImg;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	//business library
	public void createNewContact(String lastName)
	{
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	public void createNewContact(String lastName,String leadSource)
	{
		lastNameEdt.sendKeys(lastName);
		select(leadSource ,leadSourceDropDown);
		saveBtn.click();
	}
	public void createNewContact(WebDriver driver ,String lastname,String leadSource)
	{
		lastNameEdt.sendKeys(lastname);
		orgNameLookUpImg.click();
		switchToWindow(driver,"Accounts");
		searchEdt.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver ,"Contacts");
		saveBtn.click();


	}

}

