package com.crm.vtiger.TestCaseWithPom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.leadpomclass.CreateLeadPage;
import com.crm.vtiger.leadpomclass.LeadInformationPage;
import com.crm.vtiger.leadpomclass.LeadPage;

public class TC_39_SearchLeadByFirstName_Test extends BaseClass 
{
	@Test
	public void searchLeadByFirstName() throws Throwable
	{
		//Getting the Data from Json file
		String salutation = fu.getDatafromJson("salutation");
		String firstname = fu.getDatafromJson("firstname");
		String lastname = fu.getDatafromJson("lastname");
		String companyname = fu.getDatafromJson("companyname");
		String searchforfirstname = fu.getDatafromJson("searchforfirstname");

		//navigate to leadPage
		LeadPage leadPage = homePage.clickOnLeadLink();

		//click on create new lead
		CreateLeadPage createLeadPage = leadPage.clickOnCreateLeadIMG();

		//navigate to create lead page
		LeadInformationPage leadInfoPage = createLeadPage.createLead(salutation, firstname, lastname, companyname);

		//navigate to lead information page
		String actualData = leadInfoPage.getFirstNameInfo().getText();

		//navigate to home page 
		leadPage = homePage.clickOnLeadLink();

		//search lead by lead number
		leadPage.search(actualData, searchforfirstname);

		//getting expected data
		List<WebElement> firstNames = leadPage.getFirstNames();
		String expData = leadPage.getExpData(firstNames, actualData);

		//verification
		Assert.assertTrue(expData.equals(actualData));
		Reporter.log("PASS :: Searched Lead's first name is Displayed",true);
	}
}
