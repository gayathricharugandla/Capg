package Com.Gmail.Users.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

public class UserInteraction {
	private WebDriver driver;
	private ExtentTest test;
	public UserInteraction(WebDriver driver,ExtentTest test) {
		this.driver=driver;
		this.test=test;
	}
	public void getusername(String username) {
		WebElement username_element=driver.findElement(By.name("userName"));
		 username_element.sendKeys(username);
	}
	public void getpassword(String password) {
		WebElement password_element=driver.findElement(By.name("password"));
		 password_element.sendKeys(password);
	}
	public void getSubmit() {
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
	}
	public String success_msg() {
		WebElement target=driver.findElement(By.xpath("//table/tbody//td/h3[text()=\"Login Successfully\"]"));
		return target.getText();
	}
	public String error_msg() {
		WebElement target=driver.findElement(By.xpath("//span[contains(.,'Enter your userName and password correct')]"));
		return target.getText();
	}

}
