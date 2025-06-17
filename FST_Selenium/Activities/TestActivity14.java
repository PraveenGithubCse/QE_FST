package Activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestActivity14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// initializes the driver
		WebDriver driver = new FirefoxDriver();

		// open the browser
		driver.get("https://training-support.net/webelements/tables");

		// page title
		System.out.println(driver.getTitle());

		// finding num of rows and cols in table
		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		List<WebElement> cols = driver.findElements(By.xpath("//table/thead/tr/th"));
		System.out.println("Rows Size: " + rows.size());
//		for(WebElement x:rows)
//		{
//			System.out.println(x.getText());
//		}
		System.out.println("Columns Size:" + cols.size());
//		for(WebElement x:cols)
//		{
//			System.out.println(x.getText());
//		}

		// find and print book name in 5th row
		int index = 0, c = 1;
		for (WebElement x : cols) {
			if (x.getText().equals("Book Name")) {
				c += 1;
				System.out.println(c);
				break;
			}
		}
		WebElement row5 = driver.findElement(By.xpath("//table/tbody/tr[5]/td["+c+"]"));
		System.out.println("In row5: " + row5.getText());

		// click the header price sort in ascending order
		driver.findElement(By.xpath("//table/thead/tr/th[5]")).click();

		// print 5th row again
		System.out.println("Again: " + driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]")).getText());
		// closes the driver
		driver.close();
	}

}
