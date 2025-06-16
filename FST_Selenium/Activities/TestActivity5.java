package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestActivity5 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Initialize driver
		WebDriver driver= new FirefoxDriver();
									
		//Open browser on the page
		driver.get("https://training-support.net/webelements/dynamic-controls");
											
		//Page Interactions
		//Page Title
		System.out.println(driver.getTitle());
		
		//finding inout checkbox elment
		boolean bool=driver.findElement(By.xpath("//input[@name='checkbox']")).isDisplayed();
		System.out.println(bool);
		//removing the checkbox
		driver.findElement(By.xpath("//button[text()='Toggle Checkbox']")).click();
		
		Thread.sleep(3000);
		//checking for visibility of checkbox
		boolean bool1=driver.findElement(By.xpath("//input[@name='checkbox']")).isDisplayed();
		System.out.println(bool1);
		driver.close();
	}

}
