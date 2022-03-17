package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	//Step 1: declaration 
	@FindBy(name="user_name")
	private WebElement userNameEdt;

	@FindBy(name="user_password")
	private WebElement passwordEdt;

	@FindBy(id="submitButton")
	private WebElement submitBtn;

	//Step 2: Initialization - use constructor
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//Step 2: Utilization - provide getters
	public WebElement UserNameEdt()
	{
		return userNameEdt;
	}
	public WebElement getPasswordEdt()
	{
		return passwordEdt;
	}
	public WebElement getsubmitBtn()
	{
		return submitBtn;
	}


	//Business Library
	public void loginToApp(String userName,String password)
	{
		userNameEdt.sendKeys(userName);
		passwordEdt.sendKeys(password);
		submitBtn.click();
	}


}
