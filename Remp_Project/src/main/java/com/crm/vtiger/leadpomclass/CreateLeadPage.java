package com.crm.vtiger.leadpomclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;


public class CreateLeadPage extends WebDriverUtility
{
	JavaUtility ju = new JavaUtility();
	WebDriver driver;
	public CreateLeadPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "lastname")
	private WebElement lastNameTF;

	@FindBy(name = "salutationtype")
	private WebElement saluatationDropDown;
	
	@FindBy(name = "firstname")
	private WebElement firstNameTF;
	
	@FindBy(name = "company")
	private WebElement companyTF;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getLastNameTF() {
		return lastNameTF;
	}
	
	public WebElement getCompanyTF() {
		return companyTF;
	}

	public WebElement getSaluatationDropDown() {
		return saluatationDropDown;
	}
	
	public WebElement getFirstNameTF() {
		return firstNameTF;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}
	/**
	 * create lead with mandatory fields
	 * @param saluatation
	 * @param firstName
	 * @param lastName
	 * @param company
	 */
	public LeadInformationPage createLead(String saluatation,String firstName,String lastName,String company) 
	{
		selectOption(saluatationDropDown,saluatation);
		firstNameTF.sendKeys(firstName+ju.getRandomData());
		lastNameTF.sendKeys(lastName+ju.getRandomData());
		companyTF.sendKeys(company+ju.getRandomData());
		saveBtn.click();
		return new LeadInformationPage(driver);
	}
	
}
