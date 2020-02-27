package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user_email")
	WebElement email;

	@FindBy(id = "user_password")
	WebElement password;

	@FindBy(css = "[name='commit']")
	WebElement login;

	public WebElement getemail() {
		return email;
	}

	public WebElement getpassword() {
		return password;
	}

	public WebElement getlogin() {
		return login;
	}

}
