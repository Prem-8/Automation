package com.crm.vtiger.TestCase.Base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;

public class TC_37_SearchLeadByLeadNumber_Test extends BaseClass
{
	@Test(groups="regressionTest")
	public void searchLeadbyLeadNo() throws Throwable
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
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		wu.sleep(2000);
		String xp="//td[@id='mouseArea_First Name']/following-sibling::td/following-sibling::td[@class='dvtCellInfo']";
		String textValueLeadNo = driver.findElement(By.xpath(xp)).getText();
		
		//Avoiding space in the first Index
		textValueLeadNo=textValueLeadNo.substring(1);
		String actualLeadNo=textValueLeadNo;
		String actData=actualLeadNo;
		//Click on Leads
		wu.sleep(3000);
		driver.findElement(By.linkText("Leads")).click();


		//Search Lead by Lead Number
		driver.findElement(By.name("search_text")).sendKeys(textValueLeadNo);
		WebElement searchIn = driver.findElement(By.id("bas_searchfield"));
		wu.selectOption(searchIn,searchforleadno);
		driver.findElement(By.name("submit")).click();

		//verifying whether the Lead's lead number is displayed or not
		wu.sleep(2000);
		List<WebElement> leadNumbers = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[2]"));
		wu.sleep(2000);
		String expData= wu.getTextofWebElements(leadNumbers,textValueLeadNo);
		Assert.assertTrue(expData.contains(actData));
		Reporter.log("the expected data is"+expData , true);
		
	}
}
