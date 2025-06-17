package Activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestActivity13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//initializes the driver
		WebDriver driver=new FirefoxDriver();
		
		//open the browser
		driver.get("https://training-support.net/webelements/tables");
		
		//page title
		System.out.println(driver.getTitle());
		
		//finding num of rows and cols in table 
		List<WebElement> rows= driver.findElements(By.xpath("//table/tbody/tr"));
		List<WebElement> cols= driver.findElements(By.xpath("//table/thead/tr/th"));
		System.out.println("Rows Size: "+rows.size());
		System.out.println("Columns Size:"+cols.size());
		
		//find sand print all the cell values in 3rd row
		List<WebElement> row3= driver.findElements(By.xpath("//table/tbody/tr[3]"));
		for(WebElement x:row3)
		{
			System.out.println(x.getText());
		}
		
		//find 2nd row and 2nd col
		List<WebElement> row2col3= driver.findElements(By.xpath("//table/tbody/tr[2]/td[2]"));
		for(WebElement x:row2col3)
		{
			System.out.println(x.getText());
		}
		
		
		//closes the webpage
		driver.close();
		
		
	}

}
