package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestActivity2 {
	public static void main(String[] args) {
		//Initialize driver
		WebDriver driver= new FirefoxDriver();
				
		//Open browser on the page
		driver.get("https://training-support.net/webelements/login-form");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Page Interactions
		//Page Title
		System.out.println(driver.getTitle());
		
		//find username and password field
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.cssSelector("button.svelte-1pdjkmx")).click();
		String msg=driver.findElement(By.tagName("h1")).getText();
		System.out.println(msg);
		System.out.println(msg.equals("Login Success!"));
		driver.close();
	}
}
