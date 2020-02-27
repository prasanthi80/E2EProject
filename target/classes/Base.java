package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public static WebDriver driver;
    public Properties props;
    static int i=1;
	public WebDriver initializeDriver() throws IOException {
		props = new Properties();
		FileInputStream fin = new FileInputStream(
				"C:\\Users\\Lavanya\\Desktop\\Selenium-Training\\workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		props.load(fin);
		String browser = props.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Lavanya\\Desktop\\Selenium-Training\\browser-drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver" + ".driver",
					"C:\\Users\\Lavanya\\Desktop\\Selenium-Training\\browser-drivers\\geckodriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver" + ".driver",
					"C:\\Users\\Lavanya\\Desktop\\Selenium-Training\\browser-drivers\\IEDriverServer.exe");
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public void getScreenShot(String result) throws IOException
	{
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("C:\\work\\Test\\"+result+"screenshot.png"));
	}

}
