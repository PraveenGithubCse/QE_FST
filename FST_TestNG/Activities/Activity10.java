package Activities;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity10 {
	//webDriver declaration
	WebDriver driver;
		
	//WebDriverWait declaration
	WebDriverWait wait;
		
	@BeforeClass
	public void setUp()
	{
		//initialize driver
		driver=new FirefoxDriver();
		//initalize wait
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		//open the page
		driver.get("https://training-support.net/webelements/simple-form");
	}

	public static List<List<String>> readExcel(String filePath)
	{
		//create main dataset
		List<List<String>> data=new ArrayList<>();
		try {
			//open the .xlsx file for reading
			FileInputStream file=new FileInputStream(filePath);
			
			//create a workbook obj
			XSSFWorkbook wb=new XSSFWorkbook(file);
			
			//create the sheet object
			XSSFSheet sheet=wb.getSheetAt(0);
			
			//iterate through rows
			for(Row cells: sheet)
			{
				//temp list for inner rows
				List<String> rowData=new ArrayList<>();
				//iterate through each cell in row
				for(Cell cell:cells)
				{
					//add cell data to temp list
					rowData.add(cell.getStringCellValue());
				}
				//Add rowData to data(inner list is added to outer list)
				data.add(rowData);
			}
			
			//close the workbook 
			wb.close();
			//close the input strema
			file.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
		//return data to data provider
		return data;
	}
	
	
	@DataProvider(name="Events")
		
	@Test
	public Object[][] signUpInfo()
	{
		//set the file path for the input file
		String filePath = "src/test/resources/usrinfo.xlsx";
		List<List<String>> data=readExcel(filePath);
		
		//return data to test func
		return new Object[][]{
					{data.get(1)},
					{data.get(2)},
					{data.get(3)}
				};
	}
		
	@Test (dataProvider = "Events")
	public void registerTest(List<String> rows) throws InterruptedException
	{
		//wait for the form load
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Submit']")));
		
		//find full name field and enter value
		driver.findElement(By.id("full-name")).clear();
		driver.findElement(By.id("full-name")).sendKeys(rows.get(0));
		//find email filed and enter value
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(rows.get(1));
		//find date filed and enter value
		driver.findElement(By.name("event-date")).clear();
		driver.findElement(By.name("event-date")).sendKeys(rows.get(2).replaceAll("\"","" ));
		//find addi. details filed and enter value
		driver.findElement(By.id("additional-details")).clear();
		driver.findElement(By.id("additional-details")).sendKeys(rows.get(3));
		//click the button
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		//assertions
		String msg=driver.findElement(By.id("action-confirmation")).getText();
		assertEquals(msg, "Your event has been scheduled!");
		
		//refresh page
		driver.navigate().refresh();
	}

	@AfterClass
	public void tearDown()
	{
		//close the browser
		driver.close();
	}
}
