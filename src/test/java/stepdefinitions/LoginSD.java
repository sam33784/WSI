package stepdefinitions;

import org.testng.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSD {

	private static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

	@Given("QA environment is up and running")
	public void qa_environment_is_up_and_running() {

		DriverFactory.getDriver().get("https://www.facebook.com/login/");

	}
	
	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getloginpagetitle();
		System.out.println("Page title is: " + title);
	}

	
	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		Assert.assertTrue(title.contains(expectedTitleName));
	}

	


	
}
