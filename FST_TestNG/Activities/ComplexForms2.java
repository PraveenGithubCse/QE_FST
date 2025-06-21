package Activities;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ComplexForms2 {
	//declare driver
	WebDriver driver;
	//declare wait
	WebDriverWait wait;
	

	
  @Test(priority = 1)
  public void verifyTitle() {
	  assertEquals(driver.getTitle(), "Job Application Form");
  }
  
  @Test(priority = 2)
  public void settingName() {
	  driver.findElement(By.id("name")).sendKeys("Praveen");
  }
  
  @Test(priority = 3)
  public void settingEmail() {
	  driver.findElement(By.id("email")).sendKeys("praveen@ex.com");
  }
  
  @Test(priority = 4)
  public void settingPhoneNum() {
	  driver.findElement(By.id("phone")).sendKeys("7893200359");
  }
  
  @Test(priority = 5)
  public void selectPos() {
	  WebElement s=driver.findElement(By.id("position"));
	  Select select=new Select(s);
	  //selecting the postion using visibletext
	  select.selectByVisibleText("Full Stack Developer");
  } 
  
  @Test(priority = 6)
  public void settingCurStatus() {
	  driver.findElement(By.xpath("//input[@value='Student']")).click();
  }
  
 @Test(priority = 7)
  public void uploadResume() {
	  File f=new File("src/test/resources/RESUME_BELLA VENKATA PRAVEEN KUMAR.pdf");
	//Upload the file
	driver.findElement(By.id("resume")).sendKeys(f.getAbsolutePath());
  }
  
 @Test(priority = 8)
 public void clickSubmint() {
	  driver.findElement(By.xpath("//button[text()='Submit']")).click();
 }
 
  @Test(priority = 9)
  public void verifySuccMeg() {
	  assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation"))).getText(), "Application Submitted Successfully!");
  }
  
  @Test(priority = 10)
  public void clickingSubmit() {
	  driver.findElement(By.xpath("//button[text()='Submit']"));
  }
  
  @BeforeClass
  public void beforeClass() {
	  //initialize driver
	  driver=new FirefoxDriver();
	  //initialize wait
	  wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	  //opening the webpage
	  driver.get("https://training-support.net/complex-forms/job-application");
  }

  @AfterClass
  public void afterClass() {
	  //closes the page
	  driver.close();
  }

}
