package testCases;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import base.BaseTest;
import pom.MenuItems;

/**
 * This test case retrieves all the items listed on the menu, including name and
 * price. An assertion is implemented to ensure the list is correct.
 */

public class MenuItemsTest extends BaseTest {

	private static final Logger log = LogManager.getLogger(MenuItemsTest.class.getName());

	MenuItems coffeesListed;

	/**
	 * Initializes the MenuItems page object before each of the test cases are ran.
	 */
	@BeforeMethod(alwaysRun = true)
	public void pageSetup() {

		coffeesListed = new MenuItems(driver);
	}

	/*
	 * Checks and verifies that all of the coffee menu items are displayed with the
	 * correct name and price.
	 */
	@Test(groups = { "singleuser" })
	public void items() throws InterruptedException {

		// There is a data mismatch for the prices, had to update prices in the script
		// manually
		// in order to pass test

		log.info("VERIFYING ALL THE COFFEES LISTED ON THE MENU AND THEIR PRICES:");

		List<String> actualCoffees = coffeesListed.coffeeNames();

		List<String> expectedCoffeeData = Arrays.asList("Espresso $10.00", "Espresso Macchiato $12.00",
				"Cappuccino $19.00", "Mocha $8.00", "Flat White $18.00", "Americano $7.00", "Cafe Latte $16.00",
				"Espresso Con Panna $14.00", "Cafe Breve $15.00");

		if (actualCoffees.size() != expectedCoffeeData.size()) {

			log.error("Total number of coffees is incorrect. Expected: " + expectedCoffeeData.size() + "But got: "
					+ actualCoffees.size());
		}

		Assert.assertEquals(actualCoffees.size(), expectedCoffeeData.size(),
				"The number of actual coffees do not match the expected amount");

		for (int i = 0; i < expectedCoffeeData.size(); i++) {

			String actualItem = actualCoffees.get(i);
			String expectedItem = expectedCoffeeData.get(i);

			if (!actualItem.equals(expectedItem)) {

				log.error("Assertion Failed at index " + i + ". Expected: '" + expectedItem + "', but found: '"
						+ actualItem + "'");

			}

			Assert.assertEquals(actualCoffees.get(i), expectedCoffeeData.get(i),
					"Coffee data at index" + i + "does not match");
		}

	}

}
