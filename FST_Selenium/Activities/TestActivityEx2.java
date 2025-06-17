package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestActivityEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// initializes the driver
		WebDriver driver = new FirefoxDriver();
		Actions act=new Actions(driver);

		// open the browser
		driver.get("https://training-support.net/webelements/sliders");

		// page title
		System.out.println(driver.getTitle());

		WebElement slider=driver.findElement(By.id("volume"));
		WebElement vol=driver.findElement(By.cssSelector("h1.text-5xl.font-extrabold"));
		
		//set to 25%
		act.moveToElement(slider).clickAndHold(slider).moveByOffset(-120, 0).release().build().perform();
		//print new value
		System.out.println(vol.getText());
		//move to 75%
		act.moveToElement(slider).clickAndHold(slider).moveByOffset(120, 0).release().build().perform();
		//print new value
		System.out.println(vol.getText());

		//move to 55%
		act.moveToElement(slider).clickAndHold(slider).moveByOffset(22, 0).release().build().perform();
		//print new value
		System.out.println(vol.getText());
				
		//closes the page
		driver.close();
	}

}
