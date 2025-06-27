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
	
    private static final Logger log = LogManager.getLogger(AddItemsToCart.class.getName());


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

		purchaseBtn.click();
		name.sendKeys("Raja Bhamra");
		email.sendKeys("raja@gmail.com");
		checkBox.click();
		submitBtn.click();

	}

	public String paymentMsg() {

		wait.until(ExpectedConditions.visibilityOf(confirmMsg));
		String txt = confirmMsg.getText();
		System.out.println("--------------------------------------------------");
		log.info("Purchase Confirmation Message: " + " " + txt);
		System.out.println("--------------------------------------------------");
		return txt;

	}

}
