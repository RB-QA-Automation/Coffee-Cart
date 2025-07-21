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

	public void clickPurchase() {

		clickElement(purchaseBtn);
	}

	public void fullName(String userName) {

		name.sendKeys(userName);

	}

	public void email(String userEmail) {

		email.sendKeys(userEmail);

	}

	public void tickBox() {

		clickElement(checkBox);

	}

	public void subBtn() {

		clickElement(submitBtn);
	}

	public String paymentMsg() {

		wait.until(ExpectedConditions.visibilityOf(confirmMsg));
		String txt = confirmMsg.getText();
		log.info("Purchase Confirmation Message: " + " " + txt);
		return txt;

	}

}
