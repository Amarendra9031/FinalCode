package com.crm.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class GoibioTest 
{
	@Test
	public void goibioTest() throws InterruptedException
	{

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize(); 
		driver.get("https://www.goibibo.com/");
		
		Actions actions=new Actions(driver);
		actions.moveByOffset(10, 10).click().perform();
		
		driver.findElement(By.xpath("//span[@class='sc-gsNilK dImRia']")).click();
		WebElement From_City = driver.findElement(By.xpath("//span[.='From']"));
		From_City.sendKeys("Bengaluru (BLR)");
		From_City.sendKeys(Keys.RETURN);
		Thread.sleep(4000);
		
		WebElement To_City = driver.findElement(By.xpath("//span[.='To']"));
		To_City.sendKeys("New Delhi (DEL)");
		To_City.sendKeys(Keys.RETURN);
		Thread.sleep(4000);
		
		
		//driver.quit();
	}
}
