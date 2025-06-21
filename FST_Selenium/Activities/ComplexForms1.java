package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComplexForms1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//initializing driver
		WebDriver driver=new FirefoxDriver();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		//opening webpage
		driver.get("https://training-support.net/complex-forms/simple-payment");
		//printing page title 
		System.out.println(driver.getTitle());
		
		//getting initial balance
		String bal=driver.findElement(By.name("accountBalance")).getDomProperty("value");
		//printing initial acc balance
		System.out.println(driver.findElement(By.className("svelte-1x1dj7u")).getText()+" :"+ bal);
		
		//setting the amount to pay
		driver.findElement(By.id("paymentAmount")).clear();
		driver.findElement(By.id("paymentAmount")).sendKeys("575");
		
		//clicking the button pay
		driver.findElement(By.xpath("//button[text()='Pay']")).click();
		
		//printing the payment success message
		WebElement w=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'payment is')]")));
		System.out.println(w.getText());
		
		//close the browser
		driver.close();
	}

}
