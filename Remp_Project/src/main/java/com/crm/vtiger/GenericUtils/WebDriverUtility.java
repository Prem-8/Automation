package com.crm.vtiger.GenericUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.basic.BasicSliderUI.ActionScroller;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class contains WebDriver specific methods
 * @Prem
 *
 */
public class WebDriverUtility 
{
	/**
	 * this method wait for 20 sec for page loading
	 * 
	 * @param driver
	 */
	public void waitUntillPageLoad(WebDriver driver) 
	{

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * This method will wait until the visibility of the webelement
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementVisibility(WebDriver driver, WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * this method wait for the element to be clicked
	 * 
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element) throws InterruptedException 
	{
		int count = 0;
		while (count < 40) {
			try {
				element.click();
				break;
			} catch (Throwable e) {
				Thread.sleep(5000);
				count++;
			}
		}
	}

	/**
	 * This method enables the user to select dropdown using visible text
	 * 
	 * @param element
	 * @param option
	 */
	public void selectOption(WebElement element, String option) {
		Select select = new Select(element);
		select.selectByVisibleText(option);
	}

	/**
	 * This method enables the user to select dropdown using index
	 * 
	 * @param element
	 * @param index
	 */
	public void selectOption(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * This method will perform move hover action
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	/**
	 * This method helps to switch from one window to another
	 * 
	 * @param driver
	 * @param partialwinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialwinTitle) {
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while (it.hasNext()) {
			String winId = it.next();
			String title = driver.switchTo().window(winId).getTitle();
			if (title.contains(partialwinTitle)) {
				break;
			}
		}
	}

	/**
	 * accept alert
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * dismiss alert
	 * 
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * to right click on particular element
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element);
	}

	public void scrollToWebElement(WebDriver driver,WebElement element) {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		int y=element.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+y+")", element);
	}

	public void switchFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}

	public void switchFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchFrame(WebDriver driver,String idOrName) {
		driver.switchTo().frame(idOrName);
	}


	public void takeScreenShot(WebDriver driver,String screenShotName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/"+screenShotName+".PNG");
		Files.copy(src, dest);
	}


	/**
	 * Keyboard enter key press
	 * @param key
	 * @throws AWTException
	 */
	public void pressEnterKey(KeyEvent key) throws AWTException {
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	/**
	 * This method sleeps for a while
	 * @param sleeptime
	 * @throws Throwable 
	 */
	public void sleep(long sleepTime) throws Throwable
	{
		Thread.sleep(sleepTime);
	}

	/**
	 * This method helps to get the text of the WebElements
	 * @throws Throwable 
	 * @author Prem
	 */
	public String getTextofWebElements(List<WebElement> elements,String option) throws Throwable
	{
		
		for(WebElement element : elements)
		{
			sleep(2000);
			if(element.getText().equals(option))
			{

				return element.getText();
			}
		}
		return null;
	}

	/**
	 * This method helps us to deal with Page Verification using URl
	 * @Prem
	 */
	public Boolean pageVerification(WebDriver driver,String partialURl)
	{
		boolean flag=false;
		if(driver.getCurrentUrl().contains(partialURl))
		{
			return flag=true;
		}
		else
		{
			return flag;
		}
	}
	
	/**
	 * This method helps us to deal with Page Verification using title
	 * @Prem
	 */
	public Boolean pageVerification(String partialTitle,WebDriver driver)
	{
		boolean flag=false;
		if(driver.getTitle().contains(partialTitle))
		{
			return flag=true;
		}
		else
		{
			return flag;
		}
	}
	
	/**
	 * This method helps us to deal with selecting particular value
	 * @throws Throwable 
	 * @Prem
	 */
	public void selectValueandClick(List<WebElement> elements,String option) throws Throwable
	{
		for(WebElement ele : elements)
		{
			if(ele.getText().equals(option))
			{
				sleep(1000);
				ele.click();
				break;
			}
		}
	}
	
	public String removeSpaceintheFirstIndex(String text)
	{
		text=text.substring(1);
		return text;
	}

}
