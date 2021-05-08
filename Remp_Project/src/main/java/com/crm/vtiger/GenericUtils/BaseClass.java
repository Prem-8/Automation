package com.crm.vtiger.GenericUtils;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.crm.vtiger.pomclass.HomePage;
import com.crm.vtiger.pomclass.LoginPage;

public class BaseClass 
{
	public HomePage homePage;
	public WebDriver driver;
	public static WebDriver sdriver;
	public FileUtility fu = new FileUtility();
	public WebDriverUtility wu = new WebDriverUtility();
	public JavaUtility ju = new JavaUtility();
	
	
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void configBS()
	{
		//Enable DB connection
	}

	@BeforeTest(groups= {"smokeTest","regressionTest"})
	public void configBT()
	{
		//launch browser in parallel mode
	}
	
	@Parameters("browser")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void configBC(@Optional("chrome")String browser) throws Throwable 
	{
		String browserName = fu.getDatafromJson("browser");

		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}

		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}

		else
		{
			System.out.println("Unsupported Browser");
		}
		
		sdriver=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@SuppressWarnings("unused")
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void setUp() throws Throwable
	{

		//Getting the Url
		String url = fu.getDatafromJson("url");
		driver.get(url);

		//Login to Application
		String username = fu.getDatafromJson("username");
		String password = fu.getDatafromJson("password");
		
		LoginPage loginPage=new LoginPage(driver);
		homePage= loginPage.login(username, password);
	}

	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void tearDown() throws Throwable
	{
		//Sign Out from Application
		homePage.signOut();
	}

	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void configAC()
	{
		driver.quit();
	}

	@AfterTest(groups= {"smokeTest","regressionTest"})
	public void configAT()
	{
		//close driver ref in parallel mode
	}

	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void configAS()
	{
		//close DataBase connection
	}

}
