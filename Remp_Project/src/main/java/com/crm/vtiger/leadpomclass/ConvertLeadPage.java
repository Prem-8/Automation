package com.crm.vtiger.leadpomclass;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.pomclass.OragnizationInformationPage;

public class ConvertLeadPage 
{
	WebDriver driver;
	
	public ConvertLeadPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="select_potential")
	private WebElement opportunityCheckBox;
	
	@FindBy(id="jscal_trigger_closedate")
	private WebElement calendarIcon;
	
	@FindBy(xpath="//div[contains(@style,'block') and @class='calendar']//td[text()='›']")
	private WebElement nextMonthIcon;
	
	@FindBy(name="Save")
	private WebElement saveBtn;
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getOpportunityCheckBox() {
		return opportunityCheckBox;
	}

	public WebElement getCalendarIcon() {
		return calendarIcon;
	}

	public WebElement getNextMonthIcon() {
		return nextMonthIcon;
	}
	
	public OragnizationInformationPage convertLead(int days)
	{
		// Getting LocalDateTime
				LocalDateTime ldt = LocalDateTime.now().plusDays(days);
				int date = ldt.getDayOfMonth();
				String month = ldt.getMonth().name();
				month = month.substring(0,1).toUpperCase() + month.substring(1).toLowerCase();
				int year = ldt.getYear();
		
		opportunityCheckBox.click();
		calendarIcon.click();
		String xp = "//div[contains(@style,'block') and @class='calendar']//td[text()='"+month+", "+year+"']/ancestor::thead/following-sibling::tbody//td[text()='"+date+"']";

		for(;;)
		{
		
			try
			{
				driver.findElement(By.xpath(xp)).click();
				break;
			}

			catch(Exception e)
			{
				nextMonthIcon.click();
			}
		}
		saveBtn.click();
		return new OragnizationInformationPage(driver);
	}
	
	
}
