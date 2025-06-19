package Activities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestActivity19 {

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
		
		//clicking the confirm button
		driver.findElement(By.id("confirmation")).click();
		
		//wait for the alert box
		wait.until(ExpectedConditions.alertIsPresent());
		
		//print the alert text
		Alert al=driver.switchTo().alert();
		System.out.println(al.getText());
		
		//alert closing with ok
		al.accept();
		
		//print confirmation form ok button
		System.out.println(driver.findElement(By.id("result")).getText());
				
		
		//clicking the confirm button
		driver.findElement(By.id("confirmation")).click();
		
		//wait for the alert box
		wait.until(ExpectedConditions.alertIsPresent());
				
		//print the alert text
		Alert al1=driver.switchTo().alert();
		System.out.println(al1.getText());
				
		//alert closing with cancel
		al1.dismiss();
		
		//print confirmation form cancel button
		System.out.println(driver.findElement(By.id("result")).getText());
		
		//close the page
		driver.close();
	}

}
