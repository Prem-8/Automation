package com.crm.vtigerTestCases_PropertyData;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class TC_40_SearchLeadByCompanyName_Test 
{
	@Test
	public void searchLeadByCompanyName() throws Throwable
	{
		//Initializing property file
		FileUtility fu = new FileUtility();
		WebDriverUtility wu = new WebDriverUtility();
		JavaUtility ju = new JavaUtility();
		String username = fu.getDatafromJson("username");
		String password = fu.getDatafromJson("password");
		String url = fu.getDatafromJson("url");
		String salutation = fu.getDatafromJson("salutation");
		String firstname = fu.getDatafromJson("firstname");
		String lastname = fu.getDatafromJson("lastname");
		String companyname = fu.getDatafromJson("companyname");
		String searchforleadno = fu.getDatafromJson("Lead No");
		String searchforlastname = fu.getDatafromJson("Last Name");
		String searchforfirstname = fu.getDatafromJson("First Name");
		String searchforcompany = fu.getDatafromJson("searchforcompanyname");
		String duration = fu.getDatafromJson("duration");


		//Launching Browser
		//WebDriverUtility webDriverUtility = new WebDriverUtility();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		//Getting the Url
		driver.get(url);

		//Login to Application
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();


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
		if(wu.getTextofWebElements(leadCompanyNames,textValue))
		{
			System.out.println("Searched Lead's Company Name is Displaying in the Lead Module");
		}
		else
		{
			System.out.println("Searched Lead's Company Name is Not Displaying in the Lead Module");
		}

		//Sign Out from Application
		wu.sleep(2000);
		WebElement signOut=driver.findElement(By.xpath("//img[contains(@src,'user')]"));
		wu.mouseHover(driver, signOut);
		wu.sleep(2000);
		driver.findElement(By.xpath("//a[contains(@href,'Logout')]")).click();

		//Closing the connection
		driver.quit();
	}
}
