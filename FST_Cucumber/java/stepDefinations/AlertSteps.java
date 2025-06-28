package stepDefinations;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlertSteps extends BaseClass {
	@Given("User is on the alerts page")
	public void openLoginPage() {
		// opening the login page
		driver.get("https://training-support.net/webelements/alerts");
	}

	@When("User clicks the Simple Alert button")
	public void simpleAlert() {
		driver.findElement(By.id("simple")).click();
	}

	@When("User clicks the Confirm Alert button")
	public void confirmAlert() {
		driver.findElement(By.id("confirmation")).click();
	}

	@When("User clicks the Prompt Alert button")
	public void promptAlert() {
		driver.findElement(By.id("prompt")).click();
	}

	@Then("Alert opens")
	public void alertOpens() {
		// getting the alert msg
		al = driver.switchTo().alert();
	}

	@And("Read the text from it and print it")
	public void readAlert() {
		System.out.println("The Alert msg: " + al.getText());
	}

	@And("write a custom message in it")
	public void writeMsg() {
		al.sendKeys("I am Praveen!!");
	}

	@And("Close the alert")
	public void closeAlert() {
		al.accept();
	}

	@And("Read the result text")
	public void readMsg() {
		System.out.println(driver.findElement(By.id("result")).getText());
	}
}
