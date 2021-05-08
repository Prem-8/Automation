package com.crm.vtigerTestCases_PropertyData;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class TC_37_SearchLeadByLeadNumber_Test 
{
	@Test
	public void searchLeadbyLeadNo() throws Throwable
	{
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
		String searchforleadno = fu.getDatafromJson("searchforleadno");
		String searchforlastname = fu.getDatafromJson("Last Name");
		String searchforfirstname = fu.getDatafromJson("First Name");
		String searchforcompany = fu.getDatafromJson("Company");
		String duration = fu.getDatafromJson("duration");
		String leadno = fu.getDatafromJson("leadno");

		//Launching Browser
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
		wu.sleep(5000);
		driver.findElement(By.linkText("Leads")).click();

		
		//Search Lead by Lead Number
		driver.findElement(By.name("search_text")).sendKeys(leadno);
		WebElement searchIn = driver.findElement(By.id("bas_searchfield"));
		wu.selectOption(searchIn,searchforleadno);
		driver.findElement(By.name("submit")).click();

		//verifying whether the Lead's lead number is displayed or not
		List<WebElement> leadNumbers = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[2]"));
		if(wu.getTextofWebElements(leadNumbers,leadno))
		{
			System.out.println("Searched Lead's Lead Number is Displayed in the Lead Module");
		}
		else
		{
			System.out.println("Searched Lead's Lead Number is Not Displayed in the Lead Module");
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
