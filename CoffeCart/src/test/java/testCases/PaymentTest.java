package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import base.BaseTest;
import pom.Payment;

public class PaymentTest extends BaseTest {

	Payment pay;

	@BeforeMethod
	public void pageSetup() {

		pay = new Payment(driver);

	}

	@Test(dependsOnMethods = "testCases.ViewCartTest.updatedCart")
	public void purchaseFlow() {

		pay.paymentDetails();

		String actualMsg = pay.paymentMsg();

		String expectedMsg = "Thanks for your purchase. Please check your email for payment.";
		
		Assert.assertEquals(actualMsg, expectedMsg);

	}

}
