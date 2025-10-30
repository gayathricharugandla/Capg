package Com.Gmail.Users.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Com.Gmail.Users.Config.Reports;

public class UserInteraction_Reports {
	private WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest test;
	public UserInteraction_Reports(WebDriver driver,ExtentTest test) {
		this.test=test;
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	}
	@FindBy(name="userName")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(how=How.XPATH, using="//input[@value='Submit']")
	private WebElement Submit;
	
//	@FindBy(how=How.XPATH,using="//h3[normalize-space()='Login Successfully']")
//	private WebElement success;
//	
//	@FindBy(how=How.XPATH,using="//span[contains(.,'Enter your userName and password correct')]")
//	private WebElement error;
	
	public void getusername(String unm) {
		//username.sendKeys(unm);
		boolean flag=true;
		try {
			wait.until(ExpectedConditions.visibilityOf(username));
			username.sendKeys(unm);
			Reports.generateReport(driver, test, Status.PASS, "Username element found and entered");
			
		}
		catch(TimeoutException te) {
			flag=false;
			Reports.generateReport(driver,test,Status.FAIL,"Username element not found");
		}
	}
	public void getpassword(String pwd) {
		password.sendKeys(pwd);
//		boolean flag=true;
//		try {
//			wait.until(ExpectedConditions.visibilityOf(password));
//			Reports.generateReport(driver, test, Status.PASS, "Password element found and entered");
//			password.sendKeys(pwd);
//		}
//		catch(TimeoutException te) {
//			flag=false;
//			Reports.generateReport(driver,test,Status.FAIL,"Password element not found");
//		}
		
	}
	public void getSubmit() {
		Submit.click();
//		boolean flag=true;
//		try {
//			wait.until(ExpectedConditions.visibilityOf(Submit));
//			Reports.generateReport(driver, test, Status.PASS, "Submit element found and entered");
//			Submit.click();
//		}
//		catch(TimeoutException te) {
//			flag=false;
//			Reports.generateReport(driver,test,Status.FAIL,"Submit element not found");
//		}
		
	}
	public boolean final_msg(String res) {
		boolean actResult = true;
		WebElement ele;
		if(res.equals("Login Successfully")) {
			 ele = driver.findElement(By.xpath("//h3[normalize-space()='Login Successfully']"));
		}else {
			ele=driver.findElement(By.xpath("//span[normalize-space()='Enter your userName and password correct']"));
		}
		
		try {
			wait.until(ExpectedConditions.visibilityOf(ele));
			if(ele.getText().matches("Login Successfully")){
	   			Reports.generateReport(driver, test, Status.PASS, "Valid User");
	   		 }
	   		 else
	   		 {
	   			actResult = false;
	            Reports.generateReport(driver, test, Status.FAIL, "Invalid Credentials");
	   		 }
		}catch (Exception te) {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Wait time exceeded...");
        }
		
	   	 return actResult;
}
}
