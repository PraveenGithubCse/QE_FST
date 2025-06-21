package stepDefinations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FirstExample extends BaseClass {
	@Given ("the user is on the TS homepage")
	public void openHomePage()
	{
		//open the TS Homepage
		driver.get("https://training-support.net");		
	}
	
	@When("they click on the About Us button")
	public void clickAboutLink()
	{
		//find and click the about us button
		driver.findElement(By.linkText("About Us")).click();
	}
	
	@Then("they are redirecting to the About Us page")
	public void verifyRedirect()
	{
		//verify the page title
		assertEquals("About Training Support",driver.getTitle());
	}
}
