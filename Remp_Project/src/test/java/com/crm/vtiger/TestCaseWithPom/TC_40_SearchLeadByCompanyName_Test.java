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

public class TC_40_SearchLeadByCompanyName_Test extends BaseClass 
{
	@Test
	public void searchLeadByCompanyName() throws Throwable
	{
		
		System.out.println("Hello prem  6  ");

		
		/*
		
		
		//Getting the Data from Json file
		String salutation = fu.getDatafromJson("salutation");
		String firstname = fu.getDatafromJson("firstname");
		String lastname = fu.getDatafromJson("lastname");
		String companyname = fu.getDatafromJson("companyname");
		String searchforcompanyname = fu.getDatafromJson("searchforcompanyname");

		//navigate to lead page
		LeadPage leadPage = homePage.clickOnLeadLink();

		//click on create new lead
		CreateLeadPage createLeadPage = leadPage.clickOnCreateLeadIMG();

		//navigate to create lead page
		LeadInformationPage leadInfoPage = createLeadPage.createLead(salutation, firstname, lastname, companyname);

		//navigate to lead information page
		String actualData = leadInfoPage.getCompanyNameInfo().getText();

		//navigate to home page 
		leadPage = homePage.clickOnLeadLink();

		//search lead by lead number
		leadPage.search(actualData, searchforcompanyname);

		//getting expected data
		List<WebElement> companyNames = leadPage.getCompanyNames();
		String expData = leadPage.getExpData(companyNames, actualData);

		//verification
		Assert.assertTrue(expData.equals(actualData));
		Reporter.log("PASS :: Searched Lead's company name is Displayed",true);
		
		
		*/
	}
}
