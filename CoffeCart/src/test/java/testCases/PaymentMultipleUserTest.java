package testCases;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

/**
 * This class contains a data-driven test for the end to end purchase flow of
 * multiple users. The test verifies that multiple users are able to
 * successfully complete a purchase. Test includes adding items to cart to
 * verifying the confirmation purchase message. User info is obtained via an
 * Excel sheet.
 */
public class PaymentMultipleUserTest extends BaseTest {

	private static final Logger log = LogManager.getLogger(PaymentMultipleUserTest.class.getName());

	MenuItems coffeesListedd;
	AddItemsToCart beveragess;
	ViewCart carts;
	PaymentMultipleUser pays;

	/**
	 * Initializes all the required Page Objects before each test method is ran,
	 * ensures that each test has fresh instances of the page classes.
	 */
	@BeforeMethod(alwaysRun = true)
	public void pageSetup() {

		pays = new PaymentMultipleUser(driver);
		beveragess = new AddItemsToCart(driver);
		coffeesListedd = new MenuItems(driver);
		carts = new ViewCart(driver);

	}

	/**
	 * A method using TestNG provider that passes in the location of the excel file
	 * which contains the nesseccary data, this includes multiple user's names and
	 * email addresses.
	 * 
	 * @return An 2D Object array that reads all the data from the excel sheet.
	 * @throws IOException When an operation is failed or interrupted. In this case
	 *                     if the Excel file is not found or read.
	 */
	@DataProvider(name = "paymentData")
	public Object[][] paymentDataProvider() throws IOException {

		String filePath = "src/test/java/resources/Data Driven Testing - Coffee Cart.xlsx";

		return ExcelReader.getTestData(filePath, "Sheet1");

	}

	/**
	 * A test case which runs the complete end to end purchase flow for multiple
	 * users, includes viewing the menu, adding items to cart, entering user details
	 * in checkout and complete purchase.
	 * 
	 * @param nameFromExcel  Name of the user.
	 * @param emailFromExcel Email Address of the user.
	 * @throws InterruptedException Only if the thread is interrupted.
	 */
	@Test(dataProvider = "paymentData", groups = { "multipletestuser" })
	public void purchaseFlow(String nameFromExcel, String emailFromExcel) throws InterruptedException {

		log.info("----- Starting purchase flow for user: " + nameFromExcel + "-----");

		log.info("RETRIEVING TOTAL NUMBER OF COFFEES WHICH ARE DISPLAYED ON THE MENU!");

		List<String> actualCoffees = coffeesListedd.coffeeNames();

		List<String> expectedNames = Arrays.asList("Espresso", "Espresso Macchiato", "Cappuccino", "Mocha",
				"Flat White", "Americano", "Cafe Latte", "Espresso Con Panna", "Cafe Breve");

		List<String> expectedPrices = Arrays.asList("$10.00", "$12.00", "$19.00", "$8.00", "$18.00", "$7.00", "$16.00",
				"$14.00", "$15.00");

		if (actualCoffees.size() != expectedNames.size()) {

			log.error("Total number of coffees is incorrect. Expected: " + expectedNames.size() + "But got: "
					+ actualCoffees.size());
		}

		log.info("VERIFYING THE NAMES OF EACH COFFEE LISTED ON THE MENU!");

		Assert.assertEquals(actualCoffees.size(), expectedNames.size());

		for (int i = 0; i < expectedNames.size(); i++) {

			String actualData = actualCoffees.get(i);
			String expectedName = expectedNames.get(i);
			String expectedPrice = expectedPrices.get(i);

			if (!actualData.equals(expectedName)) {

				log.error("Assertion failed at index: " + i + "Expected: " + expectedName + "But found: " + actualData);

			}

			Assert.assertTrue(actualData.contains(expectedName), "Item #" + i
					+ " did not contain the expected name. Expected: '" + expectedName + "' in '" + actualData + "'");

			if (!actualData.equals(expectedPrice)) {

				log.error(
						"Assertion failed at index: " + i + "Expected: " + expectedPrice + "But found: " + actualData);

			}

			Assert.assertTrue(actualData.contains(expectedPrice), "Item #" + i
					+ " did not contain the expected price. Expected: '" + expectedPrice + "' in '" + actualData + "'");
		}

		log.info("ADDING ITEMS TO CART AND VERIFYING TOTAL COST!");

		beveragess.addingItems();

		String finalPrice = beveragess.totalCost();

		String expectedPrice = "Total: $33.00";

		if (!finalPrice.equals(expectedPrice)) {

			log.error("Total cost does not match. Expected: " + expectedPrice + "But found: " + finalPrice);
		}

		Assert.assertEquals(finalPrice, expectedPrice, "The total cost is incorrect");

		log.info("VERIFYING PROMO TEXT!");

		String proTxt = beveragess.promoText();

		String actualProText = "It's your lucky day! Get an extra cup of Mocha for $4.";

		if (!proTxt.equals(actualProText)) {

			log.error("Promotion text does not match. Expected: " + actualProText + "But found: " + proTxt);
		}

		Assert.assertEquals(proTxt, actualProText, "The promotion text does not match");

		String updatedCost = beveragess.acceptPromoOffer();

		log.info("VERIFYING UPDATED TOTAL COST AFTER ADDING PROMO OFFER!");

		String expectedNewCost = "Total: $37.00";

		if (!updatedCost.equals(expectedNewCost)) {

			log.error("Updated total cost after adding promo offer does not match. Expected: " + expectedNewCost
					+ "But found: " + updatedCost);
		}

		Assert.assertEquals(updatedCost, expectedNewCost, "The updated price is incorrect");

		String currentPriceDisplayed = carts.currentTotal();

		String currentExpected = "Total: $37.00";

		if (!currentPriceDisplayed.equals(currentExpected)) {

			log.error("Current price does not match. Expected: " + currentExpected + "But found: "
					+ currentPriceDisplayed);
		}

		Assert.assertEquals(currentPriceDisplayed, currentExpected);

		carts.addAndRemove();

		log.info("VERIFYING NEW FINAL PRICE!");

		String finalPrices = carts.finalTotal();

		String finalExpected = "Total: $44.00";

		if (!finalPrices.equals(finalExpected)) {

			log.error("The final price does not match: Expected: " + finalExpected + "But found: " + finalPrices);

		}

		Assert.assertEquals(finalPrices, finalExpected);

		log.info("CONFIRMING FINAL ORDERS!");

		carts.finalItems();

		pays.paymentDetails(nameFromExcel, emailFromExcel);

		String actualMsg = pays.paymentMsg();

		String expectedMsg = "Thanks for your purchase. Please check your email for payment.";

		if (!actualMsg.equals(expectedMsg)) {

			log.error("Purchase confirmation message does not match. Expected: " + expectedMsg + "But found: "
					+ actualMsg);
		}

		Assert.assertEquals(actualMsg, expectedMsg);

	}

}
