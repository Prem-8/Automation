package com.crm.vtiger.TestCase.Base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;

public class TC_40_SearchLeadByCompanyName_Test extends BaseClass
{
	@Test(groups="regressionTest")
	public void searchLeadByCompanyName() throws Throwable
	{

		//Click on Leads
		driver.findElement(By.linkText("Leads")).click();

		//Create Lead
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		WebElement saluatation = driver.findElement(By.name("salutationtype"));
		wu.selectOption(saluatation,salutation);
		driver.findElement(By.name("firstname")).sendKeys(firstname  + ju.getRandomData());
		driver.findElement(By.name("lastname")).sendKeys(lastname + ju.getRandomData());
		driver.findElement(By.name("company")).sendKeys(companyname + ju.getRandomData());
		String textValue = driver.findElement(By.name("company")).getAttribute("value");
		String actData=textValue;
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//Click on Leads
		wu.sleep(3000);
		driver.findElement(By.linkText("Leads")).click();


		//Search Lead by Company Name
		driver.findElement(By.name("search_text")).sendKeys(textValue);
		WebElement searchIn = driver.findElement(By.id("bas_searchfield"));
		wu.selectOption(searchIn,searchforcompany);
		driver.findElement(By.name("submit")).click();

		//verifying whether the company name is displayed or not
		wu.sleep(2000);
		List<WebElement> leadCompanyNames = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[5]"));
		String expData= wu.getTextofWebElements(leadCompanyNames,textValue);
		Assert.assertTrue(expData.contains(actData));
		Reporter.log("the expected data is"+expData , true);
		

		
	}
}
