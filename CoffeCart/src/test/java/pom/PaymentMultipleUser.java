package pom;

import org.openqa.selenium.WebDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class PaymentMultipleUser extends BasePage {

	private static final Logger log = LogManager.getLogger(PaymentMultipleUser.class.getName());

	public PaymentMultipleUser(WebDriver driver) {

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

	public void paymentDetails(String excelName, String excelEmail) {

		clickElement(purchaseBtn);
		log.debug("Clicking on purchase button");
		purchaseBtn.click();

		log.debug("Entering name in field");
		name.sendKeys(excelName);

		log.debug("Entering email in field");
		email.sendKeys(excelEmail);

		clickElement(checkBox);
		log.debug("Ticking checkbox");
		checkBox.click();

		clickElement(submitBtn);
		log.debug("Clicking on submit button");
		submitBtn.click();

	}

	public String paymentMsg() {

		wait.until(ExpectedConditions.visibilityOf(confirmMsg));
		String txt = confirmMsg.getText();
		log.info("Purchase Confirmation Message: " + " " + txt);
		return txt;

	}

}
