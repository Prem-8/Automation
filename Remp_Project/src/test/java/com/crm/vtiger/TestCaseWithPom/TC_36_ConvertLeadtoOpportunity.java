package com.crm.vtiger.TestCaseWithPom;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.leadpomclass.ConvertLeadPage;
import com.crm.vtiger.leadpomclass.CreateLeadPage;
import com.crm.vtiger.leadpomclass.LeadInformationPage;
import com.crm.vtiger.leadpomclass.LeadPage;
import com.crm.vtiger.pomclass.OragnizationInformationPage;

public class TC_36_ConvertLeadtoOpportunity extends BaseClass
{
	@Test
	public void convertLeadtoOpportunity() throws Throwable
	{
		//Getting the Data from Json file
		String salutation = fu.getDatafromJson("salutation");
		String firstname = fu.getDatafromJson("firstname");
		String lastname = fu.getDatafromJson("lastname");
		String companyname = fu.getDatafromJson("companyname");
		String duration = fu.getDatafromJson("duration");
		//Converting String value into integer
		int days = Integer.parseInt(duration);

		
		//navigate to leadPage
		LeadPage leadPage = homePage.clickOnLeadLink();
		
		//click on create new lead
		CreateLeadPage createLeadPage = leadPage.clickOnCreateLeadIMG();
		
		//navigate to create lead page
		LeadInformationPage leadInfoPage = createLeadPage.createLead(salutation, firstname, lastname, companyname);
		
		//click on convert lead
		wu.sleep(2000);
		ConvertLeadPage convertLeadpage = leadInfoPage.clickOnConvertLeadLink();
		wu.sleep(2000);
		
		//navigate to convert lead page
		OragnizationInformationPage orgInfoPage = convertLeadpage.convertLead(days);
		wu.sleep(1000);
		
		//verification
		String orgName = orgInfoPage.getOrganizationText();
		String industryName = orgInfoPage.getIndustryText();
		industryName=industryName.substring(1);
		wu.sleep(2000);
		Assert.assertTrue(orgName.contains(industryName));	
		Reporter.log("PASS :: Organisation name is Displayed as per Expectation",true);
		
	}
}
