package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	public static WebDriver driver;

	@BeforeMethod
	public static void launch() {

		driver = new ChromeDriver();
		driver.get("https://coffee-cart.app/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();

	}

	@AfterMethod
	public static void close() throws InterruptedException {

		Thread.sleep(3000);

		driver.close();

	}

}
