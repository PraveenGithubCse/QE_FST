package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestActivityEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Initialize driver
		WebDriver driver= new FirefoxDriver();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
															
		//Open browser on the page
		driver.get("https://training-support.net/webelements/tabs");
															
		//Page Interactions
		//Page Title
		System.out.println(driver.getTitle());
		
		driver.findElement(By.cssSelector("button.bg-purple-200")).click();
		
		int c=0;
		while(true)
		{
			c+=1;
			for(String x:driver.getWindowHandles())
			{
				driver.switchTo().window(x);
			}
			if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.mt-5"))).getText().equals("code: release"))
			{
				System.out.println("Message Found");
				System.out.println("On this tab: "+c+" "+driver.getWindowHandle());
				break;
			}
			else
			{
				driver.findElement(By.xpath("//button[text()='Open Another One']")).click();
			}
		}
		
		driver.quit();
	}

}
