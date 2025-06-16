package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestActivity15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Initialize driver
		WebDriver driver= new FirefoxDriver();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
									
		//Open browser on the page
		driver.get("https://training-support.net/webelements/dynamic-attributes");
											
		//Page Interactions
		//Page Title
		System.out.println(driver.getTitle());
		
		//find input fields and type in that
		driver.findElement(By.xpath("//input[starts-with(@id,'full-name-')]")).sendKeys("Some Name");
		driver.findElement(By.xpath("//input[contains(@id,'-email')]")).sendKeys("name@ex.com");
		driver.findElement(By.xpath("//input[contains(@name,'-event-date-')]")).sendKeys("2025-06-19");
		driver.findElement(By.xpath("//textarea[contains(@id,'-additional-details-')]")).sendKeys("Random Details");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		String msg=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation"))).getText();
		System.out.println(msg);
		
		driver.close();
	}

}
