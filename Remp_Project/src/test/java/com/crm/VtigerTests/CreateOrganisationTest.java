package com.crm.VtigerTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateOrganisationTest 
{
	@Test
	public void createOrganisation() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("http://localhost:8888");
		
		//Login to Application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Click on Organization
		driver.findElement(By.linkText("Organizations")).click();
		
		//Click on Create organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Creating Organization
		driver.findElement(By.name("accountname")).sendKeys("TY12");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Sign Out from Application
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		WebElement signOut=driver.findElement(By.xpath("//img[contains(@src,'user')]"));
		action.moveToElement(signOut).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(@href,'Logout')]")).click();
		
		//Closing the connection
		driver.quit();
	
	}
}
