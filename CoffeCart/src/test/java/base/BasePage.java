package base;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert; // Import the Alert class
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * BasePage class which acts as a foundation for all page object model classes,
 * includes essential methods for interacting with web elements such as clicking
 * and inputting text. In addition to storing alerts.
 */
public class BasePage {

	public WebDriver driver;
	public WebDriverWait wait;

	/**
	 * Constructor for BasePage class which initializes the WebDriver and
	 * WebDriverWatit.
	 * 
	 * @param driver The WebDriver instance which is to be used by the page object.
	 */
	public BasePage(WebDriver driver) {

		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	/**
	 * A clickElement method which first waits for an element to be clickable before
	 * clicking on it.
	 * 
	 * @param element The element which will be clicked when presented.
	 */
	protected void clickElement(WebElement element) {

		this.wait.until(ExpectedConditions.elementToBeClickable(element));
		try {

			element.click();

		} catch (ElementClickInterceptedException e) {

			System.out.println("Element was not clickable");

		}

	}

	/**
	 * An enterText method which first waits for the element to be visible and
	 * cleared, then the text can be entered.
	 * 
	 * @param element The element in which the text is entered.
	 * @param text    The text which is entered.
	 */
	protected void enterText(WebElement element, String text) {

		this.wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * Waits for a JavaScript alert to be present, then is accepted.
	 */
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

	/**
	 * Waits for a JavaScript alert to be present, then is declined
	 */
	public void dismissAlert() {

		wait.until(ExpectedConditions.alertIsPresent());

		Alert alert = driver.switchTo().alert();

		System.out.println("Declining alert with the following text... " + " " + alert.getText());

		alert.dismiss();

	}

}
