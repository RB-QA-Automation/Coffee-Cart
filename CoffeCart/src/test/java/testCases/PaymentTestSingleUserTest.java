package testCases;

import org.testng.annotations.Test;

import Utilities.ExcelReader;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import base.BaseTest;
import pom.PaymentMultipleUser;
import pom.PaymentSingleUser;

public class PaymentTestSingleUserTest extends BaseTest {

	PaymentSingleUser pay;

	@BeforeMethod
	public void pageSetup() {

		pay = new PaymentSingleUser(driver);

	}

	@Test(dependsOnMethods = "testCases.ViewCartTest.updatedCart", groups = { "singleuser" })
	public void purchaseFlow() {

		pay.paymentDetails();

		String actualMsg = pay.paymentMsg();

		String expectedMsg = "Thanks for your purchase. Please check your email for payment.";

		Assert.assertEquals(actualMsg, expectedMsg);

	}

}
