package Examples;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//In TestNg we never create main function

public class FirstTest {
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
		driver.get("https://training-support.net");
	}
	
	
	@Test
	public void testMethod1()
	{
		System.out.println("Test Method 1 executed");
	}
	
	@Test
	public void testMethod2()
	{
		System.out.println("Test Method 2 executed");
	}

	@AfterClass
	public void tearDown()
	{
		//close the browser
		driver.close();
	}
}
