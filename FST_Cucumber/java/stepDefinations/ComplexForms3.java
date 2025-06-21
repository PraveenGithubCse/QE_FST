package stepDefinations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ComplexForms3 extends ComplexForms3BaseClass{
	@Given ("the user is on the Catering Service web page")
	public void openHomePage()
	{
		//open the TS Homepage
		driver.get("https://training-support.net/complex-forms/catering");		
	}
	
	@When("the user enters name into the Full Name field")
	public void enterUserName()
	{
		//enter user name
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Praveen");
	}
	
	@And("the user enters phone number into the Phone field")
	public void enterPhoneNum()
	{
		//enter phone number
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("7893200359");
	}
	
	@And ("the user enters address into the Address field")
	public void enterAddress()
	{
		//enter address
		driver.findElement(By.id("address")).sendKeys("BCIT");
	}
	
	@And("the user selects event from the Event Type dropdown")
	public void selectEvent()
	{
		//select event type
		WebElement w=driver.findElement(By.id("catering-type"));
		Select s=new Select(w);
		//select by index
		s.selectByIndex(1);
	}
	
	@And("the user sets the number of guests to 150 using the slider")
	public void setNumOfGuests()
	{
		//setting num of guests to 150
		WebElement w=driver.findElement(By.xpath("//input[@id='num-guests']"));
		Actions act=new Actions(driver);
		//setting to 150
		act.moveToElement(w).clickAndHold(w).moveByOffset(370, 0).release().build().perform();
	}
	
	@And ("the user checks for food preferences")
	public void setFoodPreferences()
	{
		//setting preference to vegeterian adn dairy free
		driver.findElement(By.xpath("//span[text()='Vegetarian']")).click();
		driver.findElement(By.xpath("//span[text()='Dairy-Free']")).click();
	}
	
	@And("the user sets date as the Event Date")
	public void setDate()
	{
		//setting event date
		driver.findElement(By.xpath("//input[@id='event-date']")).sendKeys("2025-06-27");
	}
	
	@And("the user sets time as the Event Time")
	public void setTime()
	{
		//set time
		driver.findElement(By.xpath("//input[@id='event-time']")).sendKeys("17:00");
	}
	
	@And ("the user clicks the Submit button")
	public void clickSubmit()
	{
		//clicking submit
		driver.findElement(By.xpath("//button[text()='Submit']")).click();	
	}

	@Then("a confirmation message should be displayed")
	public void checkSucMsg()
	{
		//verify the success message
		assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation"))).getText(),"Booking Successful!");
	}
}
