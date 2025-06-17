package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestActivity17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// initializes the driver
		WebDriver driver = new FirefoxDriver();

		// open the browser
		driver.get("https://training-support.net/webelements/selects");

		// page title
		System.out.println(driver.getTitle());

		WebElement w = driver.findElement(By.cssSelector("select.h-80"));
		Select s = new Select(w);
		WebElement multilistText = driver.findElement(By.cssSelector("p.w-1\\/2"));

		s.deselectByVisibleText("Rust");
		// select by
		s.selectByVisibleText("HTML");
		System.out.println("From visible text: " + multilistText.getText());

		// select 4 5 6 options using index
		s.selectByIndex(3);
		s.selectByIndex(4);
		s.selectByIndex(5);
		System.out.println("From visible text: " + multilistText.getText());

		// select node using value
		s.selectByValue("nodejs");
		System.out.println("From visible text: " + multilistText.getText());

		// deselect 5th option using index
		s.deselectByIndex(4);

		// print all selected options
		for (WebElement x : s.getAllSelectedOptions()) {
			System.out.println(x.getText());
		}

		// closes the page
		driver.close();
	}

}
