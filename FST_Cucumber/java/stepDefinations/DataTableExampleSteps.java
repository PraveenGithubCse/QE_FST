package stepDefinations;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataTableExampleSteps extends BaseClass{
	@Given("user is on the To-Do list page")
	public void openToDoLstPage()
	{
		//open browser page
		driver.get("https://training-support.net/webelements/todo-list");
	}
	
	@When("user adds the following tasks")
	public void inputTasks(DataTable inputTasks) throws InterruptedException
	{
		//take list of tasks and convert into List<String>
		List<String> tasks=inputTasks.asList();
		System.out.println(tasks);
		
		//add tasks to page
		for(String task:tasks)
		{
			//find text field and type task desc
			driver.findElement(By.id("todo-input")).sendKeys(task);
			//find and click add button
			driver.findElement(By.id("todo-add")).click();
			Thread.sleep(2000);
		}	
	}
	
	@Then("they can see the task added to the list")
	public void verifyTasks()
	{
		//Assertions
		List<WebElement> taskAdded=wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//ul/li//h3"),3));
		Assertions.assertEquals(5, taskAdded.size());
	}
}
