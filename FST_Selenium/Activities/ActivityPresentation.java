package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ActivityPresentation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Initialize driver
		WebDriver driver= new FirefoxDriver();
						
		//Open browser on the page
		driver.get("https://training-support.net/webelements/login-form");
		//Page Interactions
		//Page Title
		System.out.println(driver.getTitle());
		
		WebElement usrele=driver.findElement(By.id("username"));
		WebElement psdele=driver.findElement(By.id("password"));
		WebElement butele=driver.findElement(By.cssSelector("button.svelte-1pdjkmx"));
		
		//checking for elements are displayed or hidden
		System.out.println("Username Element is displaying on the page: "+usrele.isDisplayed());
		System.out.println("Password Element is displaying on the page: "+psdele.isDisplayed());
		System.out.println("Submit button Element is displaying on the page: "+butele.isDisplayed());
				
		//find username and password field
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		
		//clicking the submit button
		driver.findElement(By.cssSelector("button.svelte-1pdjkmx")).click();
		
		//printing the success message
		String msg=driver.findElement(By.tagName("h1")).getText();
		System.out.println(msg);
		
		//reverifying the success message
		System.out.println("Verification Success: "+msg.equals("Login Success!"));
		
		//closing the browser page
		driver.close();
		
	}

}
