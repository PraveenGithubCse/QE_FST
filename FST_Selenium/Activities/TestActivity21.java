package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestActivity21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Initialize driver
		WebDriver driver= new FirefoxDriver();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
							
		//Open browser on the page
		driver.get("https://training-support.net/webelements/tabs");
															
		//Page Interactions
		//Page Title
		System.out.println(driver.getTitle());
		
		//find button and click it
		driver.findElement(By.cssSelector("button.bg-purple-200")).click();
		
		//wait for new tab to open
		//wait.until(ExpectedConditions.numberOfWindowsToBe(1));
		
		//print all handles
		System.out.println(driver.getWindowHandles());
		
		for(String x:driver.getWindowHandles())
		{
			driver.switchTo().window(x);
		}
		
		//printing the text on the new tab
		System.out.println(driver.findElement(By.cssSelector("h1.inline-flex")).getText());
		
		//printing the msg on the new tab
		System.out.println(driver.findElement(By.cssSelector("h2.mt-5")).getText());
		
		//do this again click on new another tab and print al the messages
		driver.findElement(By.xpath("//button[text()='Open Another One']")).click();
		
		//print all handles
		System.out.println(driver.getWindowHandles());
				
		for(String x:driver.getWindowHandles())
		{
			driver.switchTo().window(x);
		}
		

		//printing the text on the new tab
		System.out.println(driver.findElement(By.cssSelector("h1.inline-flex")).getText());
				
		//printing the msg on the new tab
		System.out.println(driver.findElement(By.cssSelector("h2.mt-5")).getText());
						
		//closes all tabs 
		driver.quit();		
	}

}
