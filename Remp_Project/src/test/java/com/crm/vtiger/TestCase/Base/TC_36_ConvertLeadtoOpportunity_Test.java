package com.crm.vtiger.TestCase.Base;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;

public class TC_36_ConvertLeadtoOpportunity_Test  extends BaseClass
{
	

	@Test(groups="smokeTest")
	public void convertLeadtoOpportunity() throws Throwable
	{

		//Click on Leads
		wu.sleep(5000);
		driver.findElement(By.linkText("Leads")).click();

		//Create Lead
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		WebElement saluatation = driver.findElement(By.name("salutationtype"));
		wu.selectOption(saluatation,salutation);
		driver.findElement(By.name("firstname")).sendKeys(firstname  + ju.getRandomData());
		driver.findElement(By.name("lastname")).sendKeys(lastname + ju.getRandomData());
		driver.findElement(By.name("company")).sendKeys(companyname + ju.getRandomData());
		String textValue = driver.findElement(By.name("lastname")).getAttribute("value");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//Click on Leads
		wu.sleep(3000);
		driver.findElement(By.linkText("Leads")).click();

		//Search Lead by Last Name
		driver.findElement(By.name("search_text")).sendKeys(textValue);
		WebElement searchIn = driver.findElement(By.id("bas_searchfield"));
		wu.selectOption(searchIn, "Last Name");
		driver.findElement(By.name("submit")).click();
		wu.sleep(3000);

		//Select Lead
		List<WebElement> elementss = driver.findElements(By.xpath("//a[@title='Leads']"));
		wu.selectValueandClick(elementss, textValue);

		//Convert to Lead
		driver.findElement(By.linkText("Convert Lead")).click();

		//providing data in Convert Lead page
		driver.findElement(By.id("select_potential")).click();
		driver.findElement(By.id("jscal_trigger_closedate")).click();

		String xp = "//div[contains(@style,'block') and @class='calendar']//td[text()='"+month+", "+year+"']/ancestor::thead/following-sibling::tbody//td[text()='"+date+"']";

		for(;;)
		{
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			try
			{
				driver.findElement(By.xpath(xp)).click();
				break;
			}

			catch(Exception e)
			{
				driver.findElement(By.xpath("//div[contains(@style,'block') and @class='calendar']//td[text()='›']")).click();
			}
		}


		driver.findElement(By.name("lastname")).sendKeys(ju.getRandomData());
		driver.findElement(By.name("Save")).click();	

		//Verification
		String expTitle=driver.getTitle();
		String actTitle="Organizations";
		Assert.assertTrue(expTitle.contains(actTitle));
		Reporter.log("the expected data is"+expTitle , true);
	}
}
