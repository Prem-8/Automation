package com.crm.VtigerTests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateContactsTest 
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

		//Click on Contacts
		driver.findElement(By.linkText("Contacts")).click();

		//Click on create contact
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		//Selecting Organization 
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		Set<String> allWindowIds = driver.getWindowHandles();
		String parentwindowId=driver.getWindowHandle();
		for(String windowId : allWindowIds)
		{
			driver.switchTo().window(windowId);
			if(driver.getCurrentUrl().contains("Accounts&action"))
			{
				driver.findElement(By.xpath("//a[text()='TY01']")).click();
				break;
			}
		}
		//switching  back to the parent window
		driver.switchTo().window(parentwindowId);

		//Creating contact
		driver.findElement(By.name("lastname")).sendKeys("prem");
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
