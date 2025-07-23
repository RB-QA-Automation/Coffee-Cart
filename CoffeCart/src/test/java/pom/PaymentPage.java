package pom;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

/**
 * Base Page Object Model Payment class which includes the required
 * functionality needed in order to pay for the items. This class is responsible
 * for holding all the necessary elements so the single and multi user classes
 * can inherit the required methods.
 */

public class PaymentPage extends BasePage {

	public static final Logger log = LogManager.getLogger(PaymentSingleUser.class.getName());

	public PaymentPage(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "button[aria-label='Proceed to checkout']")
	WebElement purchaseBtn;

	@FindBy(xpath = "//input[@id='name']")
	WebElement name;

	@FindBy(xpath = "//input[@id='email']")
	WebElement email;

	@FindBy(xpath = "//input[@id='promotion']")
	WebElement checkBox;

	@FindBy(xpath = "//button[@id='submit-payment']")
	WebElement submitBtn;

	@FindBy(css = "div[role='button']")
	WebElement confirmMsg;

	/**
	 * A WebElement that clicks on the purchase button.
	 */
	public void clickPurchase() {

		clickElement(purchaseBtn);
	}

	/**
	 * User to enter in their first name in the required field.
	 * 
	 * @param userName Entering name of the user during checkout
	 */
	public void fullName(String userName) {

		name.sendKeys(userName);

	}

	/**
	 * User to enter in their email address in the required field
	 * 
	 * @param userEmail Entering email address of the user during checkout
	 */
	public void email(String userEmail) {

		email.sendKeys(userEmail);

	}

	/**
	 * Selecting the order updates and promotional messages checkbox
	 */
	public void tickBox() {

		clickElement(checkBox);

	}

	/**
	 * Confirming to submit order button
	 */
	public void subBtn() {

		clickElement(submitBtn);
	}

	/**
	 * Waiting for the confirmed payment message to appear on screen then grabbing
	 * text.
	 * 
	 * @return Storing purchase confirmation message in a String variable and then
	 *         return.
	 */
	public String paymentMsg() {

		wait.until(ExpectedConditions.visibilityOf(confirmMsg));
		String txt = confirmMsg.getText();
		log.info("Purchase Confirmation Message: " + " " + txt);
		return txt;

	}

}
