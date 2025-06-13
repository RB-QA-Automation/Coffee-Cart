package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	public WebDriver driver;
	public WebDriverWait wait;

	@BeforeTest
	public void launch() {

		driver = new ChromeDriver();
		driver.get("https://coffee-cart.app/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();

	}

	@AfterTest
	public void close() throws InterruptedException {

		Thread.sleep(3000);

		driver.quit();

	}

}
