package testCases;

import org.testng.annotations.Test;



import Utilities.ExcelReader;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import base.BaseTest;
import pom.PaymentMultipleUser;
import pom.PaymentSingleUser;

/**
 * A single user test case which confirms the user is able to proceed through to
 * the purchase of their items. A name and email address is required in order to
 * complete the purchase, in addition to ensuring the purchase confirmation message is correct.
 */
public class PaymentTestSingleUserTest extends BaseTest {

	private static final Logger log = LogManager.getLogger(PaymentTestSingleUserTest.class.getName());

	PaymentSingleUser pay;

	/**
	 * Initializes the PaymentSingleUser page object before each of the test cases are
	 * ran.
	 */
	@BeforeMethod(alwaysRun = true)
	public void pageSetup() {

		pay = new PaymentSingleUser(driver);

	}

	/**
	 * An end to end purchase flow is completed for a single user
	 * @throws InterruptedException only if the thread is interrupted.
	 */
	@Test(dependsOnMethods = "testCases.ViewCartTest.updatedCart", groups = { "singleuser" })
	public void purchaseFlow() throws InterruptedException {

		log.info("PURCHASE FLOW TEST WITH SINGLE USER:");

		pay.paymentDetails(prop.getProperty("default_username"), prop.getProperty("default_email"));

		String actualMsg = pay.paymentMsg();

		String expectedMsg = "Thanks for your purchase. Please check your email for payment.";

		if (!actualMsg.equals(expectedMsg)) {

			log.error(
					"Purchase confirmation text does not match. Expected: " + expectedMsg + "But found: " + actualMsg);

		}

		Assert.assertEquals(actualMsg, expectedMsg);

	}

}
