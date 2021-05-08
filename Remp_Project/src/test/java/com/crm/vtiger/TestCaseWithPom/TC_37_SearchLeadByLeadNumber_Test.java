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

public class TC_37_SearchLeadByLeadNumber_Test extends BaseClass
{
	@Test
	public void searchLeadbyLeadNo() throws Throwable
	{
		//Getting the Data from Json file
		String salutation = fu.getDatafromJson("salutation");
		String firstname = fu.getDatafromJson("firstname");
		String lastname = fu.getDatafromJson("lastname");
		String companyname = fu.getDatafromJson("companyname");
		String searchforleadno = fu.getDatafromJson("searchforleadno");

		//navigate to leadPage
		LeadPage leadPage = homePage.clickOnLeadLink();

		//click on create new lead
		CreateLeadPage createLeadPage = leadPage.clickOnCreateLeadIMG();

		//navigate to create lead page
		LeadInformationPage leadInfoPage = createLeadPage.createLead(salutation, firstname, lastname, companyname);
		
		//navigate to lead information page
		String actualData = wu.removeSpaceintheFirstIndex(leadInfoPage.getLeadNumberInfo().getText());

		//navigate to home page 
		leadPage = homePage.clickOnLeadLink();
		
		//search lead by lead number
		leadPage.search(actualData, searchforleadno);
		
		//getting expected data
		List<WebElement> leadNumbers = leadPage.getLeadNumbers();
		String expData = leadPage.getExpData(leadNumbers, actualData);
		
		//verification
		Assert.assertTrue(expData.equals(actualData));
		Reporter.log("PASS :: Searched Lead Number is Displayed",true);









	}
}
