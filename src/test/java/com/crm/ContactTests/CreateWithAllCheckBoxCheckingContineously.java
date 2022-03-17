package com.crm.ContactTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class CreateWithAllCheckBoxCheckingContineously extends BaseClass
{
	@Test
	public void CreateWithAllCheckBoxCheckingContineously() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		hp.ClickContactsLnk();
		List<WebElement> value=driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@type='checkbox']"));
		for(WebElement check :value)
		{
			
			check.click();
			Thread.sleep(3000);
		}
	}
}
