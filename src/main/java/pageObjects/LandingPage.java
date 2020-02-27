package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

	public WebDriver driver;
	public WebDriverWait wait;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10, 15);
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "a[href*='sign_in']")
//	@FindBy(xpath = "//a/span[contains(text(),'Login')]")
	WebElement signin;
	@FindBy(css = "div.text-center h2")
	WebElement title;

	@FindBy(css = "ul[class='nav navbar-nav navbar-right'] li:nth-child(8) a")
	WebElement righttopnavbar;

	public WebElement getSignIn() {
		return wait.until(ExpectedConditions.visibilityOf(signin));
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getrighttopnavbar() {
		return righttopnavbar;
	}

}
