package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;

public class TestActivity4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Initialize driver
		WebDriver driver= new FirefoxDriver();
							
		//Open browser on the page
		driver.get("https://training-support.net/webelements/target-practice");
									
		//Page Interactions
		//Page Title
		System.out.println(driver.getTitle());
					
		//find h3 text using @class
		String msg=driver.findElement(By.xpath("//h3[@class='text-3xl font-bold text-orange-600']")).getText();
		System.out.println(msg);
		//find h5 text using text()
		String msg2=driver.findElement(By.xpath("//h5[text()='Heading #5']")).getText();
		System.out.println(msg2);
		//find h5 color using contains and for hexadecimal value of color we are using Color class without color it gives rgb value
		Color msg3=Color.fromString(driver.findElement(By.xpath("//h5[contains(text(),'#5')]")).getCssValue("color"));
		System.out.println(msg3.asHex());
		//getting DOM attribute
		String ms4=driver.findElement(By.cssSelector("button.bg-purple-200")).getDomAttribute("class");
		System.out.println(ms4);
		driver.close();
	}

}
