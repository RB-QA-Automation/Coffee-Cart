package pom;

import org.openqa.selenium.WebDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class PaymentSingleUser extends BasePage {
	
    private static final Logger log = LogManager.getLogger(PaymentSingleUser.class.getName());


	public PaymentSingleUser(WebDriver driver) {

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

	public void paymentDetails() {

		log.debug("Clicking on purchase button");
		purchaseBtn.click();
		
		log.debug("Entering first and last name into field");
		name.sendKeys("Raja Bhamra");
		
		log.debug("Entering email addresss");
		email.sendKeys("raja@gmail.com");
		
		log.debug("Clicking on check box");
		checkBox.click();
		
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
