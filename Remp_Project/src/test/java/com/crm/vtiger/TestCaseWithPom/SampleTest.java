package com.crm.vtiger.TestCaseWithPom;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SampleTest {
	
	@BeforeClass
	public void configBC(){
		System.out.println("ececute before class");
	}
	
	@BeforeMethod
	public void configBM() {
		System.out.println("execute Before test");
	}
	
	@Test
	public void creatOrg(){
		System.out.println("execute creatOrg test");
	}
	@Test
	public void createOrgWithIndutries(){
		System.out.println("execute createOrgWithIndutries test");
	}
	
	@AfterMethod
	public void configAM() {
		System.out.println("execute after test");
	}
	@AfterClass
	public void configAC(){
		System.out.println("ececute after class");
	}
	

}
