package stepDefinations;

import java.time.Duration;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class ComplexFormsFixtures3 extends ComplexForms3BaseClass{
	@BeforeAll
	public static void setUp()
	{
		//initialize Firefox Driver
		driver=new FirefoxDriver();
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	@AfterAll
	public static void tearDown()
	{
		//closes the browser
		driver.quit();
	}
}
