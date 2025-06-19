package Activities;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity7 {
	//declare the driver
	WebDriver driver;
	//declare wait
	WebDriverWait wait;
  @Test (priority = 1)
  public void verifyTitlePage() {
	  assertEquals(driver.getTitle(), "Selenium: Login Form");
  }
  
  @Test (priority = 2)
  public void findFields() {
	  System.out.println(driver.findElement(By.id("username")).isDisplayed());
	  System.out.println(driver.findElement(By.id("password")).isDisplayed());
	  
  }
  
  @DataProvider(name="Credentials")
  public Object[][] creds() {
	  //Return incorrect credentials for test
	  return new Object[][] {
		  {"admin1","password1"},
		  {"admin2","password2"},
		  {"admin3","password3"},
		  {"admin4","password4"},
		  {"admin5","password5"}  
	  };
  }
  
  
  @Test (priority = 3, dataProvider = "Credentials")
  public void sendInvalCeden(String usrname, String password) {
	  driver.findElement(By.id("username")).clear();
	  driver.findElement(By.id("password")).clear();
	  driver.findElement(By.id("username")).sendKeys(usrname);
	  driver.findElement(By.id("password")).sendKeys(password);;
	  driver.findElement(By.xpath("//button[text()='Submit']")).click();
	  //getting error msg
	  String msg=driver.findElement(By.id("subheading")).getText();
	  assertEquals(msg, "Invalid credentials");
  }
  
  @Test (priority = 4)
  public void sendCreden() {
	  driver.findElement(By.id("username")).clear();
	  driver.findElement(By.id("password")).clear();
	  driver.findElement(By.id("username")).sendKeys("admin");
	  driver.findElement(By.id("password")).sendKeys("password");;
	  driver.findElement(By.xpath("//button[text()='Submit']")).click();
	  
	  String msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".text-center"))).getText();
	  assertEquals(msg, "Login Success!");
  }
  
  @Test (priority = 5)
  public void verifyConMsg() {
	  String msg=driver.findElement(By.cssSelector(".text-center")).getText();
	  assertEquals(msg,"Login Success!");
	  
  }
  
  @BeforeClass
  public void beforeClass() {
	  //initialze driver
	  driver= new FirefoxDriver();
	  //wait decalration
	  wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  //opening the page
	  driver.get("https://training-support.net/webelements/login-form");
  }

  @AfterClass
  public void afterClass() {
	  //close the page
	  driver.close();
  }

}
