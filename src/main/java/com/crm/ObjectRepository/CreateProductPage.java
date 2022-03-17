package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebdriverUtility;

public class CreateProductPage  extends WebdriverUtility
{
	@FindBy(name="productName")
	private WebElement productNameEdt;


	@FindBy(xpath="//input[@title ='save [Alt+s]']")
	private WebElement saveBtn;
	// Initialization
	public  CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//utilization 

	public WebElement getProductNameEdt()
	{
		return productNameEdt;
	}

	public WebElement getSaveBtn()
	{
		return saveBtn;
	}
	//business library
	public void createNewproductpage(String productName)
	{
		productNameEdt.sendKeys(productName);
		saveBtn.click();
	}

	public void createNewContact(WebDriver driver,String productName)
	{
		productNameEdt.sendKeys(productName);
		driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
		switchToWindow(driver ,"Products");
		saveBtn.click();

	}

}


