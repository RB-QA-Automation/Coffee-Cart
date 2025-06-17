package testCases;

import org.testng.annotations.Test;

import Utilities.ExcelReader;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import base.BaseTest;
import pom.Payment;

public class PaymentTest extends BaseTest {

	Payment pay;

	@BeforeMethod
	public void pageSetup() {

		pay = new Payment(driver);

	}

	@DataProvider(name = "paymentData")
	public Object[][] paymentDataProvider() throws IOException {

		String filePath = "src/test/java/resources/Data Driven Testing - Coffee Cart.xlsx";

		return ExcelReader.getTestData(filePath, "Sheet1");

	}

	@Test(dependsOnMethods = "testCases.ViewCartTest.updatedCart", dataProvider = "paymentData")
	public void purchaseFlow(String nameFromExcel, String emailFromExcel) {

		pay.paymentDetails(nameFromExcel, emailFromExcel);

		String actualMsg = pay.paymentMsg();

		String expectedMsg = "Thanks for your purchase. Please check your email for payment.";

		Assert.assertEquals(actualMsg, expectedMsg);

	}

}
