package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestActivity12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Initialize driver
		WebDriver driver= new FirefoxDriver();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
									
		//Open browser on the page
		driver.get("https://training-support.net/webelements/dynamic-content");
											
		//Page Interactions
		//Page Title
		System.out.println(driver.getTitle());
		
		//find and click the click me button
		driver.findElement(By.id("genButton")).click();
		
		// wait.till the word "release" appears
		WebElement word=driver.findElement(By.id("word"));
		//wait.until(ExpectedConditions.textToBePresentInElement(word,"release"); 
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("word"), "release"));
		
		//print the word to console
		String w=driver.findElement(By.id("word")).getText();
		System.out.println(w);
		
		driver.close();
	}

}
