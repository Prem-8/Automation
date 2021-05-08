package com.crm.vtiger.TestCase.Base;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
@Listeners(com.crm.vtiger.GenericUtils.ListnerClass.class)
public class Practice extends BaseClass
{
	@Test(retryAnalyzer=com.crm.vtiger.GenericUtils.RetryAnalyser.class)
	public void createUser() 
	{
		System.out.println("Hello");
		System.out.println(10/0);
	}
}
