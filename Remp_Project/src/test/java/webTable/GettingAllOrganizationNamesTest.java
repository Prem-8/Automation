package webTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GettingAllOrganizationNamesTest {
	
	@Test
	public void getOrganisationNames()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("http://localhost:8888");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		
		List<WebElement> allOrganisationName=driver.findElements(By.xpath("//table[@class='lvt small']/tbody//a[@title='Organizations']"));
		for(WebElement ele : allOrganisationName)
		{
			System.out.println(ele.getText());
		}
	}


}
