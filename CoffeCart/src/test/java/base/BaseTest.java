package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	public static WebDriver driver;
	public static WebDriverWait wait;

	@BeforeTest(alwaysRun = true)
	public void launch() {

		ChromeOptions options = new ChromeOptions();

		// options.addArguments("--headless");
		options.addArguments("--disable-gpu");
		options.addArguments("--window-size=1920,1080"); // Set a standard window size
		options.addArguments("--no-sandbox"); // A sandbox is a security mechanism; disabling it can help avoid
												// permission issues in a server environment
		options.addArguments("--disable-dev-shm-usage"); // This helps avoid resource problems in Docker/Linux
															// environments

		driver = new ChromeDriver(options);

		driver.get("https://coffee-cart.app/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();

	}

	@AfterTest(alwaysRun = true)
	public void close() throws InterruptedException {

		if (driver != null) {

			Thread.sleep(3000);
			driver.quit();
		}

	}

	public WebDriver getDriver() {

		return driver;
	}

}