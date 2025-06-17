package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestActivity8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Initialize driver
		WebDriver driver= new FirefoxDriver();
						
		//Open browser on the page
		driver.get("https://training-support.net/webelements/mouse-events");
						
						
		//Page Interactions
		//Page Title
		System.out.println(driver.getTitle());
		
		WebElement w=driver.findElement(By.xpath("//h1[text()='Cargo.lock']"));
		WebElement w2=driver.findElement(By.xpath("//h1[text()='Cargo.toml']"));
		WebElement w3=driver.findElement(By.xpath("//h1[text()='src']"));
		WebElement w4=driver.findElement(By.xpath("//h1[text()='target']"));
		
		Actions act=new Actions(driver);
		act.click(w).pause(2000).moveToElement(w2).click().build().perform();
		String msg=driver.findElement(By.id("result")).getText();
		System.out.println(msg);		
		
		act.doubleClick(w3).build().perform();
		act.contextClick(w4).pause(2000).build().perform();
		act.click(driver.findElement(By.cssSelector("span.ml-3"))).build().perform();
		System.out.println(driver.findElement(By.id("result")).getText());
		
		driver.close();
		
	}

}
