package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestActivity9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Initialize driver
		WebDriver driver= new FirefoxDriver();
						
		//Open browser on the page
		driver.get("https://training-support.net/webelements/keyboard-events");
										
		//Page Interactions
		//Page Title
		System.out.println(driver.getTitle());
		
		Actions act=new Actions(driver);
		act.sendKeys("This is Praveen!!!").build().perform();
		
		//getting the sent text
		System.out.println(driver.findElement(By.cssSelector("h1.mt-3")).getText());
		
		driver.close();
	}

}
