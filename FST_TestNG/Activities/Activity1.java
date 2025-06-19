package Activities;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
	//WebDriver Declaration
	WebDriver driver;
	//WebDriverWait Declaration
	WebDriverWait wait;
	
  @Test (priority = 1)
  public void firstTest() {
	  assertEquals(driver.getTitle(),"Training Support");
  }
  
  @Test (priority = 2)
  public void secondTest()
  {
	  //finding the button
	  driver.findElement(By.cssSelector(".card")).click();
	  //wait until page load
	  wait.until(ExpectedConditions.titleContains("About"));
	  //checking the title is matching or not
	  assertEquals(driver.getTitle(), "About Training Support");
  }
  
  
  @BeforeClass
  public void beforeClass() {
	  //initialize driver
	  driver=new FirefoxDriver();
	  //initialize wait
	  wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	  
	  //opening the webpage
	  driver.get("https://training-support.net");
  }

  @AfterClass
  public void afterClass() {
	  //close the page
	  driver.close();
  }

}
