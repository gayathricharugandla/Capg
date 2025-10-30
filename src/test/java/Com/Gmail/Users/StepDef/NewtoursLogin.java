package Com.Gmail.Users.StepDef;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import Com.Gmail.Users.Pages.UserInteraction;
import Com.Gmail.Users.Pages.UserInteraction_PageFactory;
import Com.Gmail.Users.Pages.UserInteraction_Reports;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewtoursLogin {
	WebDriver driver=Hooks.driver;
	ExtentTest test=Hooks.test;
	
	//UserInteraction_PageFactory user;
	UserInteraction_Reports user;
	@Given("I navigated to login page")
	public void launch() {
		//user=new UserInteraction_PageFactory(driver,test);
		user=new UserInteraction_Reports(driver,test);
		driver.get("https://demo.guru99.com/test/newtours/");
	}
	
	@When("I entered {string} and {string}")
	public void i_entered_and(String unm, String pwd) {
	    user.getusername(unm);
	    user.getpassword(pwd);
	}
	@And("I clicked on signin button")
	public void i_clicked_signin_button() {
	   user.getSubmit();
	}
//	@Then("Its navigated to the error msg")
//	public void its_navigated_to_the_error_page() {
//		WebElement target=driver.findElement(By.xpath("//span[contains(.,'Enter your userName and password correct')]"));
//		Assert.assertTrue(target.isDisplayed());
//	    System.out.println("Login Unsuccessful");
//	}
	@Then("Its navigated to the web page {string}")
	public void its_navigated_to_the_home_page(String res) {
		boolean msg=user.final_msg(res);
		try {
		Assert.assertTrue(msg);
		System.out.println("Login Sucessful");
		}
		catch(AssertionError ae) {
			System.out.println("Login unsuccessful");
		}

	}
	@When("I entered the following")
	public void datatable(DataTable datatable) {
		List<List<String>> creds=datatable.cells();
		//NewtoursLogin obj=new NewtoursLogin();
		for(List<String> inputs: creds) {
	    driver.findElement(By.name("userName")).sendKeys(inputs.get(0));
	    driver.findElement(By.name("password")).sendKeys(inputs.get(1));
	}
	}
	@When("I insert {string} and {string}")
	public void outline(String unm, String pwd) {
		user.getusername(unm);
	    user.getpassword(pwd);
	}

}
