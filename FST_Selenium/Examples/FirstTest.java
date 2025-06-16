package Examples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Initialize driver
		WebDriver driver= new FirefoxDriver();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//Open browser on the page
		driver.get("https://training-support.net/webelements/dynamic-controls");
		driver.manage().window().maximize();
		
		//Page Interactions
		//Page Title
		System.out.println(driver.getTitle());
		
		//find checkbox on the page
		WebElement checkBox=driver.findElement(By.id("checkbox"));
		
		//click the toggle button
		driver.findElement(By.cssSelector("button.svelte-sfj3o4")).click();
		
		
		//wait for check box to disappear
		wait.until(ExpectedConditions.invisibilityOf(checkBox));
		
		//toggle the checkbox again
		driver.findElement(By.cssSelector("button.svelte-sfj3o4")).click();
		
		//wait for it appear and then select it
		wait.until(ExpectedConditions.visibilityOf(checkBox));
		checkBox.click();
		
		//Close the browser i.e., closing the currently active tab
		driver.close();
		// driver.quit(); // closes all the tabs in the browser
	}

}
