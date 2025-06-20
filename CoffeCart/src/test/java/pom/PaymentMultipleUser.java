package pom;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class PaymentMultipleUser extends BasePage {

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

		purchaseBtn.click();
		name.sendKeys(excelName);
		email.sendKeys(excelEmail);
		checkBox.click();
		submitBtn.click();

	}

	public String paymentMsg() {

		wait.until(ExpectedConditions.visibilityOf(confirmMsg));
		String txt = confirmMsg.getText();
		System.out.println("Purchase Confirmation Message: " + " " + txt);
		return txt;

	}

}
