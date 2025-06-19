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

public class Activity2 {
	//WebDriver Declaration
	WebDriver driver;
	//WebDriverWait Declaration
	WebDriverWait wait;
	
  @Test (priority = 1)
  public void firstTest() {
	  assertEquals(driver.getTitle(),"Selenium: target Practice","Title should be matched with the provided title");
  }
  
  @Test (priority = 2)
  public void secondTest()
  {
	  //finding the button text with black
	  String buttonText=driver.findElement(By.cssSelector(".p-2")).getText();
	  //checking the buttontext is black or not
	  assertEquals(buttonText, "Black");
  }
  
  @Test (priority = 3, enabled=false) // it will be ignored completely and even shown in report also
  public void thirdCase()
  {
	  System.out.println("This is 3rd case");
	  
  }
  
  @Test (priority = 4) // it will be skipped and will reflect on report 
  public void fourthCase() throws SkipException
  {
	  throw new SkipException("This testcase should be skipped");
	  
  }
  
  
  @BeforeClass
  public void beforeClass() {
	  //initialize driver
	  driver=new FirefoxDriver();
	  //initialize wait
	  wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	  
	  //opening the webpage
	  driver.get("https://training-support.net/webelements/target-practice");
  }

  @AfterClass
  public void afterClass() {
	  //close the page
	  driver.close();
  }

}
