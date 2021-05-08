package com.crm.vtiger.GenericUtils;

import java.io.File;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListnerClass implements ITestListener
{
	@Override
	public void onTestFailure(ITestResult result)
	{
		String currentdate = new Date().toString().replace(" ", "_").replace(":", "_");
		String failedTestName=result.getMethod().getMethodName();
		EventFiringWebDriver ed=new EventFiringWebDriver(BaseClass.sdriver);
		File scrImg = ed.getScreenshotAs(OutputType.FILE);
		File dstImg = new File("./screenshot/"+failedTestName+"_"+currentdate+".png");
		try 
		{
			FileUtils.copyFile(scrImg, dstImg);
		} 
		catch(Exception e) {}
	}

}
