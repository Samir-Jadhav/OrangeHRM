package com.orangehrm.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	protected Properties prop;
	protected WebDriver driver;
	
	
	@BeforeSuite
	public void loadConfig() throws IOException {
		File file = new File(
				"C:\\Users\\samir\\eclipse-workspace\\OrangeHRMProject\\src\\main\\resources\\config.properties");

		FileInputStream fis = new FileInputStream(file);

		prop = new Properties();

		prop.load(fis);

		
	}

	@BeforeMethod
	public void setup() throws IOException {

	launchBrowser();
	configureBrowser();
}

	private void launchBrowser() {
		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			throw new IllegalArgumentException("browser not supported" + browser);
		}

	}

	private void configureBrowser() {

		// implicit wait

		int implicitwait = Integer.parseInt(prop.getProperty("implicitWait"));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitwait));

		// maximize the Window

		driver.manage().window().maximize();

		// navigate the URL

		try {
			driver.get(prop.getProperty("url"));
		} catch (Exception e) {
			System.out.println("Failed to navigate the URL:"+e.getMessage());
		}
	}

	@AfterMethod
	public void teardown() {

		if (driver != null) {
			try {
				driver.quit();
			} catch (Exception e) {
				System.out.println("unable to quit the driver:"+e.getMessage());
			}
		}
	}

}
