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

public class PaymentTestSingleUserTest extends BaseTest {

	private static final Logger log = LogManager.getLogger(PaymentTestSingleUserTest.class.getName());

	PaymentSingleUser pay;

	@BeforeMethod(alwaysRun = true)
	public void pageSetup() {

		pay = new PaymentSingleUser(driver);

	}

	@Test(dependsOnMethods = "testCases.ViewCartTest.updatedCart", groups = { "singleuser" })
	public void purchaseFlow() throws InterruptedException {

		log.info("Purchase flow test with single user:");

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
