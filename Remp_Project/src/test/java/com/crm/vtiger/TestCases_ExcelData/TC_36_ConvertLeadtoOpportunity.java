package com.crm.vtiger.TestCases_ExcelData;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class TC_36_ConvertLeadtoOpportunity 
{
	@Test
	public void convertLeadtoOpportunity() throws Throwable
	{
		//Initializing Excel file
		ExcelUtility fu = new ExcelUtility();
		String username = fu.getExcelData("Sheet1","TC_36","username");
		String password = fu.getExcelData("Sheet1","TC_36","password");
		String url = fu.getExcelData("Sheet1","TC_36","url");
		String salutation = fu.getExcelData("Sheet1","TC_36","salutation");
		String firstname = fu.getExcelData("Sheet1","TC_36","firstname");
		String lastname = fu.getExcelData("Sheet1","TC_36","lastname");
		String companyname = fu.getExcelData("Sheet1","TC_36","companyname");
		
		//Converting String value into double and double into integer 
		int days = (int)Double.parseDouble(fu.getExcelData("Sheet1","TC_36","duration"));
		

		// Getting LocalDateTime 
		LocalDateTime ldt = LocalDateTime.now().plusDays(days); int date = ldt.getDayOfMonth(); String
		month = ldt.getMonth().name(); month = month.substring(0,1).toUpperCase() +
		month.substring(1).toLowerCase(); int year = ldt.getYear();


		//Launching Browser
		JavaUtility javaUtility = new JavaUtility();
		WebDriverUtility webDriverUtility = new WebDriverUtility();
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
		webDriverUtility.sleep(5000);
		driver.findElement(By.linkText("Leads")).click();

		//Create Lead
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		WebElement saluatation = driver.findElement(By.name("salutationtype"));
		webDriverUtility.selectOption(saluatation,salutation);
		driver.findElement(By.name("firstname")).sendKeys(firstname  + javaUtility.getRandomData());
		driver.findElement(By.name("lastname")).sendKeys(lastname + javaUtility.getRandomData());
		driver.findElement(By.name("company")).sendKeys(companyname + javaUtility.getRandomData());
		String textValue = driver.findElement(By.name("lastname")).getAttribute("value");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//Click on Leads
		webDriverUtility.sleep(3000);
		driver.findElement(By.linkText("Leads")).click();

		//Search Lead by Last Name
		driver.findElement(By.name("search_text")).sendKeys(textValue);
		WebElement searchIn = driver.findElement(By.id("bas_searchfield"));
		webDriverUtility.selectOption(searchIn, "Last Name");
		driver.findElement(By.name("submit")).click();
		webDriverUtility.sleep(3000);

		//Select Lead
		List<WebElement> elementss = driver.findElements(By.xpath("//a[@title='Leads']"));
		webDriverUtility.selectValueandClick(elementss, textValue);

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


		driver.findElement(By.name("lastname")).sendKeys(javaUtility.getRandomData());
		driver.findElement(By.name("Save")).click();	

		//Verification
		if(driver.getTitle().contains("Organizations"))
		{
			System.out.println("Organisation page is displayed");
		}
		else
		{
			System.out.println("Organisation page is not displayed");

		}

		//Sign Out from Application
		webDriverUtility.sleep(2000); WebElement
		signOut=driver.findElement(By.xpath("//img[contains(@src,'user')]"));
		webDriverUtility.mouseHover(driver, signOut); 
		webDriverUtility.sleep(2000);
		driver.findElement(By.xpath("//a[contains(@href,'Logout')]")).click();

		//Closing the connection
		driver.quit();
	}
}
