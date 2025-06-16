package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestActivity3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Initialize driver
		WebDriver driver= new FirefoxDriver();
					
		//Open browser on the page
		driver.get("https://training-support.net/webelements/login-form");
							
		//Page Interactions
		//Page Title
		System.out.println(driver.getTitle());
			
		//find username and password field
		driver.findElement(By.xpath("//input[contains(@name, 'name')]")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password");
		
		//using text()
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		//using contains
//		driver.findElement(By.xpath("//button[contains(text(),'Sub')]")).click();
		
		//using xpath without functions
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//button[@class='svelte-1pdjkmx']")).click(); // using xpath
		String msg=driver.findElement(By.xpath("//h1[contains(@class,'emerald')]")).getText();
		System.out.println(msg);
		System.out.println(msg.equals("Login Success!" ));
		driver.close();
	}

}
