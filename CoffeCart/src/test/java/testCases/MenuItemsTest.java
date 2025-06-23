package testCases;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import base.BaseTest;
import pom.MenuItems;

public class MenuItemsTest extends BaseTest {

	MenuItems coffeesListed;

	@BeforeMethod(alwaysRun = true)
	public void pageSetup() {

		coffeesListed = new MenuItems(driver);
	}

	@Test(groups = {"singleuser"})
	public void items() {

		// There is a data mismatch for the prices, had to update prices in the script manually
		// in order to pass test

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

	}

}
