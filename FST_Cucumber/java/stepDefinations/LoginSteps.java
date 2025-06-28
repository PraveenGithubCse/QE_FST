package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseClass {
	@Given("the user on the login-form page")
	public void openLoginPage() {
		// opening the login page
		driver.get("https://training-support.net/webelements/login-form");
	}

	@When("the user enters the username and password")
	public void enterCredentials() {
		// entering the credentials
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
	}

	@When("the user enters the {string} and {string}")
	public void enterCredentials(String username, String password) {
		// entering the credentials
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@And("click the submit button")
	public void clickSubmit() {
		// clicking submit
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	}

	@Then("the user should able to see the confirmation page")
	public void seeConfirmation() {
		assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.text-emerald-500")))
				.getText(), "Login Success!");
	}

	@Then("the user should able to see the confirmation page {string}")
	public void seeConfirmationWithParam(String expectedMsg) {
		assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.text-emerald-500")))
				.getText(), expectedMsg);
	}

	@Then("the user should able to see the error message")
	public void seeErrorMessage() {
		assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subheading"))).getText(),
				"Invalid credentials");
	}
}
