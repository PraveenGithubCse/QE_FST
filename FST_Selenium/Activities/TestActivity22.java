package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestActivity22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Initialize driver
		WebDriver driver= new FirefoxDriver();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
						
													
		//Open browser on the page
		driver.get("https://training-support.net/webelements/popups");
															
		//Page Interactions
		//Page Title
		System.out.println(driver.getTitle());
		
		//finding button and click it
		driver.findElement(By.id("launcher")).click();
		
		//wait for the template
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("username"))));
		
		//sending keys to username
		driver.findElement(By.id("username")).sendKeys("admin");
		
		//sending keys to username
		driver.findElement(By.id("password")).sendKeys("password");
		
		//click the submit button
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		//wait for success message
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("h1.text-center"))));
		
		//printing success msg
		System.out.println(driver.findElement(By.cssSelector("h1.text-center")).getText());
				
		//close the page
		driver.close();
	}

}
