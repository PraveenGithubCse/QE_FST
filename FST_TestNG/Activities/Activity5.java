package Activities;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
	//declare the driver
		WebDriver driver;
		//declare wait
		WebDriverWait wait;
		@Test (groups = {"HeadingTests", "ButtonTests"})  
		  public void verifyTitlePage() {
			  assertEquals(driver.getTitle(), "Selenium: Target Practice");
		  }
		@Test (dependsOnMethods = {"verifyTitlePage"}, groups= {"HeadingTests"})
		  public void  headerTest1(){
			  assertEquals(driver.findElement(By.cssSelector(".text-orange-600")).getText(),"Heading #3");
		  }
		@Test (dependsOnMethods = {"verifyTitlePage"}, groups= {"HeadingTests"})
		  public void  headerTest2(){
			Color c= Color.fromString(driver.findElement(By.cssSelector(".text-purple-600")).getCssValue("color"));
			  assertEquals(c.asHex(),"#9333ea");
		  }
		
		@Test (dependsOnMethods = {"verifyTitlePage"}, groups= {"ButtonTests"})
		  public void  buttonTest1(){
			assertEquals(driver.findElement(By.cssSelector(".text-emerald-900")).getText(), "Emerald");
		  }
		
		@Test (dependsOnMethods = {"verifyTitlePage"}, groups= {"ButtonTests"})
		  public void  buttonTest2(){
			Color c= Color.fromString(driver.findElement(By.cssSelector(".text-purple-900")).getCssValue("color"));
			  assertEquals(c.asHex(),"#581c87");
		  }
		
	  @BeforeClass (alwaysRun = true)
	  public void beforeClass() {
		  //initialze driver
		  driver= new FirefoxDriver();
		  //wait decalration
		  wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		  //opening the page
		  driver.get("https://training-support.net/webelements/target-practice");
	  }

	  @AfterClass (alwaysRun = true)
	  public void afterClass() {
		  //close the page
		  driver.close();
	  }

}
