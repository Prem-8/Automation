package com.crm.vtiger.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;
import com.crm.vtiger.leadpomclass.LeadPage;

public class HomePage extends WebDriverUtility
{
	WebDriver driver;
	public HomePage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Leads")
	private WebElement leadLink;

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstratorIMG;

	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOutLink;

	public WebElement getAdminstratorIMG() {
		return adminstratorIMG;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public WebElement getLeadLink() {
		return leadLink;
	}
	
	
	/**
	 * click on lead link
	 */
	public LeadPage clickOnLeadLink() {
		leadLink.click();
		return new LeadPage(driver);
	}
	
	
	/**
	 * Sign out from application
	 */
	public void signOut() {
		mouseHover(driver, adminstratorIMG);
		signOutLink.click();
	}
}
