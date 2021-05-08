package com.crm.vtiger.leadpomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadInformationPage 
{
	WebDriver driver;
	public LeadInformationPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="dtlview_Last Name")
	private WebElement lastNameInfo;
	
	@FindBy(id="dtlview_First Name")
	private WebElement firstNameInfo;
	
	@FindBy(id="dtlview_Company")
	private WebElement companyNameInfo;
	
	@FindBy(xpath="//td[@id='mouseArea_First Name']/following-sibling::td/following-sibling::td[@class='dvtCellInfo']")
	private WebElement leadNumberInfo;
	
	@FindBy(linkText = "Convert Lead")
	private WebElement convertLeadLink;

	
	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getLastNameInfo() {
		return lastNameInfo;
	}


	public WebElement getFirstNameInfo() {
		return firstNameInfo;
	}


	public WebElement getCompanyNameInfo() {
		return companyNameInfo;
	}


	public WebElement getLeadNumberInfo() {
		return leadNumberInfo;
	}


	public WebElement getConvertLeadLink() {
		return convertLeadLink;
	}


	public ConvertLeadPage clickOnConvertLeadLink()
	{
		convertLeadLink.click();
		return new ConvertLeadPage(driver);
	}
}
