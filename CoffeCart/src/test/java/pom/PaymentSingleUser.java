package pom;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model class for single user purchases, inherits methods from the
 * PaymentPage Page Object Model. User is able to go through the purchase
 * process with providing their name and email address.
 */

public class PaymentSingleUser extends PaymentPage {

	public PaymentSingleUser(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);

	}

	/**
	 * Complete payment process for a single user, required payment details are filled in and then submitted.
	 * @param name User's full name.
	 * @param email User's email adress.
	 */
	public void paymentDetails(String name, String email) {

		log.debug("Clicking on purchase button");
		clickPurchase();

		log.debug("Entering first and last name into field");
		fullName(name);

		log.debug("Entering email addresss");
		email(email);

		log.debug("Clicking on check box");
		tickBox();

		log.debug("Clicking on submit button");
		subBtn();

	}

}
