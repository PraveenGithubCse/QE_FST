package Activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestActivityEx {

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

		driver.findElement(By.cssSelector("button.rounded-lg")).click();
		
		//data to add
		String data[]= {"10","Hover Car Racer","Mathew Reilly", "0330440160","$7.99"};
		
		for(int i=0;i<data.length;i++)
		{
			By lastRowCells= By.xpath("//table/tbody/tr[last()]/td["+(i+1)+"]");
			driver.findElement(lastRowCells).clear();
			driver.findElement(lastRowCells).sendKeys(data[i]);
		}
		
		//print data of new row
		System.out.println(driver.findElement(By.xpath("//table/tbody/tr[last()]")).getText());
		
		//closes the web page
		driver.close();
	}

}
