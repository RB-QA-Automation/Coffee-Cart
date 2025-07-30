package pom;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model class for multi user purchases, inherits methods from the
 * PaymentPage Page Object Model. Multiple Users are able to go through the purchase
 * process with providing their name and email address.
 */

public class PaymentMultipleUser extends PaymentPage {

	public PaymentMultipleUser(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);

	}
	
	/**
	 * Complete payment process for multiple users, required payment details are filled in and then submitted.
	 * @param name User's full name.
	 * @param email User's email adress.
	 */

	public void paymentDetails(String excelName, String excelEmail) {

		log.debug("Clicking on purchase button");
		clickPurchase();

		log.debug("Entering first and last name into field");
		fullName(excelName);

		log.debug("Entering email addresss");
		email(excelEmail);

		log.debug("Clicking on check box");
		tickBox();

		log.debug("Clicking on submit button");
		subBtn();


	}

}
