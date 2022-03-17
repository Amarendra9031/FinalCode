package com.crm.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SelectAnyMonthFromCalendarTest
{
	@Test
	public void selectAnyMonthFromCalendar()
	{

		String date="12";
		String monthAndYear="March 2022";
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		Actions actions=new Actions(driver);
		actions.moveByOffset(10, 10).click().perform();
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		String arrowxapth="//span[@aria-label='Next Month']";
		String datexapth="//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='12']";

		for(;;)
		{
			try
			{
				driver.findElement(By.xpath(arrowxapth)).click();
				break;
			}
			catch (Exception e)
			{
				driver.findElement(By.xpath(datexapth)).click();
				
				driver.close();
			}
		}

	}
}
