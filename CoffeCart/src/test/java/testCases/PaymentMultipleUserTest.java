package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ExcelReader;
import base.BaseTest;
import pom.PaymentMultipleUser;

public class PaymentMultipleUserTest extends BaseTest {
	
	PaymentMultipleUser pay;

	@BeforeMethod
	public void pageSetup() {

		pay = new PaymentMultipleUser(driver);

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
