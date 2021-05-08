package com.crm.vtiger.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OragnizationInformationPage 
{
	public OragnizationInformationPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement organizationInfo;

	@FindBy(id = "dtlview_Organization Name")
	private WebElement organisationName;

	public WebElement getOrganizationInfo() {
		return organizationInfo;
	}

	public WebElement getIndustryInfo() {
		return organisationName;
	} 


	public String getOrganizationText() {
		return organizationInfo.getText();
	}

	public String getIndustryText() {
		return organisationName.getText();
	}


}












