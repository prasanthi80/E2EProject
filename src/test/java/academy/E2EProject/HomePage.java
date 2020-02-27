package academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	public static Logger log = LogManager.getLogger(HomePage.class.getName());

	@BeforeTest
	public void setUp() throws IOException {

		driver = initializeDriver();
		log.info("driver is initialized");
//		driver.get(props.getProperty("url"));
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password) throws IOException {
		System.out.println("HomePage Test Started");
//		driver = initializeDriver();
		driver.get(props.getProperty("url"));
		LandingPage landingPage = new LandingPage(driver);
		landingPage.getSignIn().click();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getemail().sendKeys(username);
		loginPage.getpassword().sendKeys(password);
		loginPage.getlogin().click();
		log.info("suceesfully validated login");

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "santhi.webdev@gmail.com";
		data[0][1] = "Tester2020";
		data[1][0] = "abc@gmail.com";
		data[1][1] = "xyz";

		return data;
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null;
		log.info("HomePage driver closed");
	}

}
