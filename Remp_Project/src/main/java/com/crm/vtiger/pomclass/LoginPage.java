package com.crm.vtiger.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "user_name")
	private WebElement usernameTF;

	@FindBy(name="user_password")
	private WebElement passwordTF;

	@FindBy(id="submitButton")
	private WebElement loginBtn;

	public WebElement getUsernameTF() {
		return usernameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	/**
	 * Use this method to login to vTiger application
	 * @param username
	 * @param password
	 */
	public HomePage login(String username,String password) {
		usernameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		loginBtn.click();
		return new HomePage(driver);
	}
}
