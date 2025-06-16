package Activities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestActivity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Initialize driver
		WebDriver driver= new FirefoxDriver();
				
		//Open browser on the page
		driver.get("https://training-support.net");
				
				
		//Page Interactions
		//Page Title
		System.out.println(driver.getTitle());
				
		//Close the browser i.e., closing the currently active tab
		driver.close();
	}

}
