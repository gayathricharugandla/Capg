package Com.Gmail.Users.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class UserInteraction_PageFactory {
	private WebDriver driver;
	private ExtentTest test;
	public UserInteraction_PageFactory(WebDriver driver,ExtentTest test) {
		this.test=test;
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="userName")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(how=How.XPATH, using="//input[@value='Submit']")
	private WebElement Sumbit;
	
	@FindBy(how=How.XPATH,using="//h3[normalize-space()='Login Successfully']")
	private WebElement success;
	
	@FindBy(how=How.XPATH,using="//span[contains(.,'Enter your userName and password correct')]")
	private WebElement error;
	
	public void getusername(String unm) {
		
		username.sendKeys(unm);
	}
	public void getpassword(String pwd) {
		
		password.sendKeys(pwd);
	}
	public void getSubmit() {
		Sumbit.click();
	}
	public String success_msg() {
		
		return success.getText();
	}
	public String error_msg() {
		
		return error.getText();
	}
}
