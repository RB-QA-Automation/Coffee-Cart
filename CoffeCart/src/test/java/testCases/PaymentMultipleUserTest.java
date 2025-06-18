package testCases;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ExcelReader;
import base.BaseTest;
import pom.AddItemsToCart;
import pom.MenuItems;
import pom.PaymentMultipleUser;
import pom.ViewCart;

public class PaymentMultipleUserTest extends BaseTest {

	MenuItems coffeesListed;

	AddItemsToCart beverages;
	ViewCart cart;

	PaymentMultipleUser pay;

	@BeforeMethod
	public void pageSetup() {

		pay = new PaymentMultipleUser(driver);
		beverages = new AddItemsToCart(driver);

	}

	@DataProvider(name = "paymentData")
	public Object[][] paymentDataProvider() throws IOException {

		String filePath = "src/test/java/resources/Data Driven Testing - Coffee Cart.xlsx";

		return ExcelReader.getTestData(filePath, "Sheet1");

	}

	@Test(dependsOnMethods = "testCases.ViewCartTest.updatedCart", dataProvider = "paymentData", groups = {
			"multipletestuser" })
	public void purchaseFlow(String nameFromExcel, String emailFromExcel) {

		List<String> actualCoffees = coffeesListed.coffeeNames();

		List<String> expectedNames = Arrays.asList("Espresso", "Espresso Macchiato", "Cappuccino", "Mocha",
				"Flat White", "Americano", "Cafe Latte", "Espresso Con Panna", "Cafe Breve");

		List<String> expectedPrices = Arrays.asList("$10.00", "$12.00", "$19.00", "$8.00", "$18.00", "$7.00", "$16.00",
				"$14.00", "$15.00");

		Assert.assertEquals(actualCoffees.size(), expectedNames.size());

		for (int i = 0; i < expectedNames.size(); i++) {

			String actualData = actualCoffees.get(i);
			String expectedName = expectedNames.get(i);
			String expectedPrice = expectedPrices.get(i);

			Assert.assertTrue(actualData.contains(expectedName), "Item #" + i
					+ " did not contain the expected name. Expected '" + expectedName + "' in '" + actualData + "'");

			Assert.assertTrue(actualData.contains(expectedPrice), "Item #" + i
					+ " did not contain the expected price. Expected '" + expectedPrice + "' in '" + actualData + "'");
		}

		beverages.addingItems();

		String finalPrice = beverages.totalCost();

		String expectedPrice = "Total: $33.00";

		Assert.assertEquals(finalPrice, expectedPrice, "The total cost is incorrect");

		String proTxt = beverages.promoText();

		String actualProText = "It's your lucky day! Get an extra cup of Mocha for $4.";

		Assert.assertEquals(proTxt, actualProText, "The promotion text does not match");

		String updatedCost = beverages.acceptPromoOffer();

		String expectedNewCost = "Total: $37.00";

		Assert.assertEquals(updatedCost, expectedNewCost, "The updated price is incorrect");

		String currentPriceDisplayed = cart.currentTotal();

		String currentExpected = "Total: $37.00";

		Assert.assertEquals(currentPriceDisplayed, currentExpected);

		cart.addAndRemove();

		String finalPrices = cart.finalTotal();

		String finalExpected = "Total: $44.00";

		Assert.assertEquals(finalPrices, finalExpected);

		cart.finalItems();

		pay.paymentDetails(nameFromExcel, emailFromExcel);

		String actualMsg = pay.paymentMsg();

		String expectedMsg = "Thanks for your purchase. Please check your email for payment.";

		Assert.assertEquals(actualMsg, expectedMsg);

	}

}
