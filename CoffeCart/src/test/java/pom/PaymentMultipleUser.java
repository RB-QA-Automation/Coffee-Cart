package pom;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

public class PaymentMultipleUser extends PaymentPage {

	public PaymentMultipleUser(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);

	}

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

		paymentMsg();

	}

}
