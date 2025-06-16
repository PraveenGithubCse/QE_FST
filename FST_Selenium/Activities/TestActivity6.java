package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestActivity6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Initialize driver
		WebDriver driver= new FirefoxDriver();
									
		//Open browser on the page
		driver.get("https://training-support.net/webelements/dynamic-controls");
											
		//Page Interactions
		//Page Title
		System.out.println(driver.getTitle());
		
		//check for checkbox
		WebElement checkBox=driver.findElement(By.id("checkbox"));
		//check for seleted or not
		System.out.println(checkBox.isSelected());
		//click the checkbox
		checkBox.click();
		//check for if it is selected again and print result
		System.out.println(checkBox.isSelected());
		
		driver.close();
	}

}
