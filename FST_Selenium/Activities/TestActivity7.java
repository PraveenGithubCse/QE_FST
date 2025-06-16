package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestActivity7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Initialize driver
		WebDriver driver= new FirefoxDriver();
									
		//Open browser on the page
		driver.get("https://training-support.net/webelements/dynamic-controls");
											
		//Page Interactions
		//Page Title
		System.out.println(driver.getTitle());
		
		//finding the textfield
		WebElement txt=driver.findElement(By.id("textInput"));
		//check text filed is enabled or not
		System.out.println(txt.isEnabled());
		//check the enable button
		driver.findElement(By.id("textInputButton")).click();
		//checking for enable or not
		System.out.println(txt.isEnabled());
		//setting some text
		driver.findElement(By.id("textInput")).sendKeys("Iam Finished");
		//getting text form input field
		driver.findElement(By.id("textInputButton")).click();
		String msg=driver.findElement(By.id("textInput")).getText(); 
		System.out.println("Hello"+msg);
		driver.close();
	}

}
