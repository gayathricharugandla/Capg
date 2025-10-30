package Com.Gmail.Users.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginDemo {
	@Given("I navigate to login page")
	public void i_navigate_to_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Page navigated");
	}

	@And("I entered correct username and password")
	public void i_entered_username_and_password() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("credentials entered");
	}

	@And("I clicked signin button")
	public void i_clicked_signin_button() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("signin clicked");
	}

	@Then("Its navigated to the HomePage")
	public void its_navigated_to_the_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("homepage displayed");
	}
	@And("I entered correct username")
	public void I_entered_correct_username() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("correct username");
	}

	@But("invalid credentials")
	public void invalid_credentials() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("username or password is wrong");
	}

	@Then("Its navigated to the error message")
	public void its_navigated_to_the_error_message() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("entered invalid credentials");
	}

}
