package com.crm.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class RedBusBookTicketTest
{

	@Test
	public void redBusBookTicketTest()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		
		Actions actions=new Actions(driver);
		actions.moveByOffset(10, 10).click().perform();
		
		driver.findElement(By.xpath("//*[@id=\"src\"]")).sendKeys("Bengaluru");
		
		driver.findElement(By.xpath("//*[@id=\"dest\"]")).sendKeys("Patna");
		
		driver.findElement(By.xpath("//*[@id=\"search\"]/div/div[3]/div/label")).sendKeys("date");
		
	}
}
