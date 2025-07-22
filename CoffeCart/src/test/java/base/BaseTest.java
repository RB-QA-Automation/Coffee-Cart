package base;

import java.time.Duration;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Utilities.ConfigReader;

/*
 * Base Test class for all the test case classes in the framework. 
 * This includes the initial setup and teardown of the WebDriver, config properties and logging.
 */
public class BaseTest {

	public static WebDriver driver;
	public static WebDriverWait wait;
	private static Logger log = LogManager.getLogger(BaseTest.class.getName());
	public static Properties prop;
	public static ConfigReader configReader;

	/**
	 * WebDriver setup and launches the browser before any test in the suite run
	 * Base URL is gathered from the config.properties file
	 */
	@BeforeTest(alwaysRun = true)
	public void launch() {

		configReader = new ConfigReader();
		prop = configReader.init_prop();

		ChromeOptions options = new ChromeOptions();

		log.info("LAUNCHING THE BROWSER");

		// options.addArguments("--headless");
		options.addArguments("--disable-gpu");
		options.addArguments("--window-size=1920,1080"); // Set a standard window size
		options.addArguments("--no-sandbox"); // A sandbox is a security mechanism; disabling it can help avoid
												// permission issues in a server environment
		options.addArguments("--disable-dev-shm-usage"); // This helps avoid resource problems in Docker/Linux
															// environments

		driver = new ChromeDriver(options);

		driver.get(prop.getProperty("baseUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();

	}

	/**
	 * Method which closes the browser and quits after all the tests in the suite
	 * have been ran successfully
	 * 
	 * @throws InterruptedException if the thread is interrupted while sleepin
	 */
	@AfterTest(alwaysRun = true)
	public void close() throws InterruptedException {

		log.info("CLOSING THE BROWSER");

		if (driver != null) {

			Thread.sleep(3000);
			driver.quit();
		}

	}

	/**
	 * Access is provided to the current WebDriver instance. Important for the
	 * ExtentTestNGListener to take screenshots on when tests fail
	 * 
	 * @return The current and active WebDriver instance
	 */
	public WebDriver getDriver() {

		return driver;
	}

}