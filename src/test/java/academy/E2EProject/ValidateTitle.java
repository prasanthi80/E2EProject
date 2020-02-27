package academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateTitle extends Base {
	public static Logger log = LogManager.getLogger(HomePage.class.getName());

	@BeforeTest
	public void setUp() throws IOException {

		driver = initializeDriver();
		driver.get(props.getProperty("url"));
		log.info("driver is initialized");
	}

	@Test
	public void isvalidTitle() throws IOException {
		System.out.println("ValidateTitle \"isvalidTitle\" Test Started");
		LandingPage landingPage = new LandingPage(driver);
		String title = landingPage.getTitle().getText();
		Assert.assertTrue(title.equalsIgnoreCase("Featured Courses"));
//		Assert.assertTrue(title.contentEquals("Featured Courses"));
		log.info("successfully validated title");
	}

	@Test
	public void isNavDisplayed() throws IOException {
		System.out.println("ValidateTitle \"isNavDisplayed\" Test Started");
		LandingPage landingPage = new LandingPage(driver);
		boolean displayed = landingPage.getrighttopnavbar().isDisplayed();
		Assert.assertTrue(displayed);
		log.info("successfully validated navigation");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null;
		log.info("Validate Title driver closed");
	}

}
