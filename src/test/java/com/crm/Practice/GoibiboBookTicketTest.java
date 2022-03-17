package com.crm.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class GoibiboBookTicketTest
{
	@Test
	public void goibiboBookTicketTest() throws InterruptedException
	{
		//String date="20";
		//String daymonthAndYear="Sun Mar 20 2022";
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		
		Actions actions=new Actions(driver);
		actions.moveByOffset(10, 10).click().perform();
		
		driver.findElement(By.xpath("//p[.='Enter city or airport']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Bengaluru (BLR)");
		driver.findElement(By.xpath("//span[@class='autoCompleteTitle ']")).click();
		
		WebElement web=driver.findElement(By.xpath("//span[.='To']"));
		actions.click(web).perform();
		WebElement text = driver.findElement(By.xpath("//input[@type='text']"));
		Thread.sleep(2000);
		actions.sendKeys(text,"New Delhi (DEL)").perform();
		driver.findElement(By.xpath("//span[@class='autoCompleteTitle ']")).click();
		
		WebElement departure = driver.findElement(By.xpath("//span[.='Departure']"));
		actions.click(departure).perform();
		Thread.sleep(2000);
		String datexapth="//div[text()='March 2022']/ancestor::div[@class='DayPicker-Month']/descendant::div[@class='DayPicker-Day']/p[text()='12']";
		WebElement date = driver.findElement(By.xpath(datexapth));
		actions.click(date).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[.='Done']")).click();
		driver.findElement(By.xpath("//span[text()='SEARCH FLIGHTS']")).click();
		driver.close();
		
		
	}
}
