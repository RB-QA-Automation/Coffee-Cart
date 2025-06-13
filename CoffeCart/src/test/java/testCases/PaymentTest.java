package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pom.AddItemsToCart;
import pom.Payment;
import pom.ViewCart;

public class PaymentTest extends BaseTest {

	Payment pay;

	@BeforeMethod
	public void pageSetup() {

		pay = new Payment(driver);

	}

	@Test(dependsOnMethods = "testCases.AddItemsToCartTest.updatedCart")
	public void purchaseFlow() {

		pay.paymentDetails();

	}

}
