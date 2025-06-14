package base;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert; // Import the Alert class
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

	public WebDriver driver;
	public WebDriverWait wait;

	public BasePage(WebDriver driver) {

		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	protected void clickElement(WebElement element) {

		this.wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();

	}

	protected void enterText(WebElement element, String text) {

		this.wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(text);
	}

	protected void acceptAlert() {

		try {

			wait.until(ExpectedConditions.alertIsPresent());

			Alert alert = driver.switchTo().alert();

			System.out.println("Accepting alert with the following text..." + " " + alert.getText());
			alert.accept();
		} catch (NoAlertPresentException e) {

			System.out.println("No alert was present to accept");

		}

	}

	public void dismissAlert() {

	}

}
