package Activities;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9 {
	//webDriver declaration
	WebDriver driver;
		
	//WebDriverWait declaration
	WebDriverWait wait;
		
	@BeforeClass
	public void setUp()
	{
		//initialize driver
		driver=new FirefoxDriver();
		//initalize wait
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		//open the page
		driver.get("https://training-support.net/webelements/alerts");
		Reporter.log("Browser Opened!!");
	}
		
	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("Test Case Started!!");
		driver.switchTo().defaultContent();
	}
		
	@Test(priority = 1)
	public void simpleAlert()
	{
		Reporter.log("Simple Alert Test Case Started");
		driver.findElement(By.id("simple")).click();
		Reporter.log("Simple Button Clicked");
		
		//Switch to alert window
		Alert al=driver.switchTo().alert();
		Reporter.log("Switched focus to alert!!");
		
		//getting the text prompted
		Reporter.log("Alert Text is: "+al.getText());
		
		//assertion
		assertEquals("You've just triggered a simple alert!", al.getText());
		
		//accepting the alert
		al.accept();
		Reporter.log("Alert closed");
		
		Reporter.log("Test case ended!!");
	}
		
	@Test (priority = 2)
	public void confirmAlert()
	{
		Reporter.log("Confirmation Alert Test Case Started");
		driver.findElement(By.id("confirmation")).click();
		Reporter.log("Confirmation Button Clicked");
		
		//Switch to alert window
		Alert al=driver.switchTo().alert();
		Reporter.log("Switched focus to alert!!");
		
		//getting the text prompted
		Reporter.log("Alert Text is: "+al.getText());
		
		//assertion
		assertEquals("You've just triggered a confirmation alert!", al.getText());
		
		//accepting the alert
		al.accept();
		Reporter.log("Alert closed on clicking ok");
		
		Reporter.log("Test case ended!!");
	}
	
	
	@Test (priority = 3)
	public void promptAlert()
	{
		Reporter.log("Prompt Alert Test Case Started");
		driver.findElement(By.id("prompt")).click();
		Reporter.log("Prompt Button Clicked");
		
		//Switch to alert window
		Alert al=driver.switchTo().alert();
		Reporter.log("Switched focus to alert!!");
		
		//getting the text prompted
		Reporter.log("Alert Text is: "+al.getText());
		
		//sending prompt
		al.sendKeys("Hello!!");
		Reporter.log("Prompt send");
		
		
		//accepting the alert
		al.accept();
		Reporter.log("Alert closed on clicking ok");
		
		Reporter.log("Test case ended!!");
	}

	@AfterClass
	public void tearDown()
	{
		//close the browser
		driver.close();
	}

}
