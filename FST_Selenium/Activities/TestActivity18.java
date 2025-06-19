package Activities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestActivity18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Initialize driver
		WebDriver driver= new FirefoxDriver();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
				
											
		//Open browser on the page
		driver.get("https://training-support.net/webelements/alerts");
													
		//Page Interactions
		//Page Title
		System.out.println(driver.getTitle());
		
		//clicking on the simple button
		driver.findElement(By.id("simple")).click();
		
		//wait until alert is dsplayed
		wait.until(ExpectedConditions.alertIsPresent());
		
		//storing the alert in the variable and printing the alert text
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		
		//clicking the ok button of the alert
		alert.accept();
		
		//verifying the alert text
		System.out.println(driver.findElement(By.id("result")).getText());
		
		//closing the page
		driver.close();
		
		
	}

}
