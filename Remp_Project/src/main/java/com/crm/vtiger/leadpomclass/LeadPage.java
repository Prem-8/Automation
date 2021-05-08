package com.crm.vtiger.leadpomclass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class LeadPage extends WebDriverUtility
{
	WebDriver driver;
	public LeadPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Lead...']")
	private WebElement createLeadIMG;
	
	@FindBy(name="search_text")
	private WebElement searchForTF;
	
	@FindBy(id="bas_searchfield")
	private WebElement searchInDropDown;
	
	@FindBy(xpath="//table[@class='lvt small']/tbody/tr[*]/td[2]")
	private List<WebElement> leadNumbers;
	
	@FindBy(xpath="//table[@class='lvt small']/tbody/tr[*]/td[3]")
	private List<WebElement> lastNames;
	
	@FindBy(xpath="//table[@class='lvt small']/tbody/tr[*]/td[4]")
	private List<WebElement> firstNames;
	
	@FindBy(xpath="//table[@class='lvt small']/tbody/tr[*]/td[5]")
	private List<WebElement> companyNames;
	
	@FindBy(name="submit")
	private WebElement searchNowBtn;

	

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateLeadIMG() {
		return createLeadIMG;
	}

	public WebElement getSearchForTF() {
		return searchForTF;
	}

	public WebElement getSearchInDropDown() {
		return searchInDropDown;
	}

	public List<WebElement> getLeadNumbers() {
		return leadNumbers;
	}

	public List<WebElement> getLastNames() {
		return lastNames;
	}

	public List<WebElement> getFirstNames() {
		return firstNames;
	}

	public List<WebElement> getCompanyNames() {
		return companyNames;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	/**
	 * click on create lead image
	 */
	public CreateLeadPage clickOnCreateLeadIMG() 
	{
		createLeadIMG.click();
		return new CreateLeadPage(driver);
	}
	
	public void search(String leadNo,String searchForLeadNo) throws Throwable
	{
		searchForTF.sendKeys(leadNo);
		selectOption(searchInDropDown, searchForLeadNo);
		searchNowBtn.click();
		sleep(2000);
	}
	
	public String getExpData(List<WebElement> leadData , String actualData) throws Throwable
	{
		String expData = getTextofWebElements(leadData, actualData);
		return expData;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
