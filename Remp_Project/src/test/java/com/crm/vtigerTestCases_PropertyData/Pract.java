package com.crm.vtigerTestCases_PropertyData;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Pract 
{
	@Test
	public void creatNewLeadByGivingValidInputToPhoneAndMobile() 
	{

		//launch the browser
		WebDriver driver=new FirefoxDriver();

		driver.get("http://localhost:8888");
		//login to the application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		//navigate to lead
		driver.findElement(By.linkText("Leads")).click();

		//create lead by entering valid mobAndPhoneNmber
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		String named="ramboro27";
		System.out.println(named);
		boolean listedName=false;
		driver.findElement(By.name("lastname")).sendKeys(named);
		driver.findElement(By.name("company")).sendKeys("johnJohnson");
		driver.findElement(By.id("phone")).sendKeys("7512345684");
		driver.findElement(By.id("mobile")).sendKeys("7510111011");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String s=driver.findElement(By.xpath("//div[@id='tblLeadInformation']/table/tbody/tr/td[4]")).getText();
		System.out.println(s);
		driver.findElement(By.linkText("Leads")).click();
		List<WebElement>leadList= driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]"));
		for(WebElement element:leadList) 
		{
			if(element.getText().equals(leadList))
			{
				System.out.println("True");
				break;
			}

		}



		driver.quit();
	}
}
