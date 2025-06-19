package Activities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestActivity20 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Initialize driver
		WebDriver driver = new FirefoxDriver();
		//implicit wait for every action for 10 sec
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Open browser on the page
		driver.get("https://training-support.net/webelements/alerts");

		// Page Interactions
		// Page Title
		System.out.println(driver.getTitle());

		// clicking the promt button
		driver.findElement(By.id("prompt")).click();

		// getting the alert msg
		Alert al = driver.switchTo().alert();
		// printing the alert msg
		System.out.println(al.getText());

		// sending prompt
		al.sendKeys("Praveen");

		// wait for 2 sec
		Thread.sleep(2000);
		// accept the alert
		al.accept();

		// getting prompt message
		System.out.println(driver.findElement(By.id("result")).getText());

		// close the page
		driver.close();

	}

}
