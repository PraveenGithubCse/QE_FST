package Activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestActivity16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// initializes the driver
		WebDriver driver = new FirefoxDriver();

		// open the browser
		driver.get("https://training-support.net/webelements/selects");

		// page title
		System.out.println(driver.getTitle());

		WebElement w=driver.findElement(By.cssSelector("select.h-10"));
		Select s=new Select(w);
		
		//select 2nd option form visibl txt
		s.selectByVisibleText("Two");
		System.out.println("From visible text: "+driver.findElement(By.cssSelector("p.mt-5")).getText());
		
		//select 3rd option
		s.selectByIndex(3);
		System.out.println("By Index: "+driver.findElement(By.cssSelector("p.mt-5")).getText());
		
		//select using value
		s.selectByValue("four");
		System.out.println("By Value: "+driver.findElement(By.cssSelector("p.mt-5")).getText());
		
		//getting all options
		List<WebElement> option=s.getOptions();
		System.out.println("Printing all options");
		for(WebElement x:option)
			System.out.println(x.getText());
		
		driver.close();
	}

}
