package testCases;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import base.BaseTest;
import pom.AddItemsToCart;

/**
 * This test case verifies the functionality of adding items to the card and has
 * an assertion which checks the current price against the expected price. In
 * addition to adding the promotion offer is available, added and testing that
 * the new price is displayed correctly.
 */
public class AddItemsToCartTest extends BaseTest {

	private static final Logger log = LogManager.getLogger(AddItemsToCartTest.class.getName());

	AddItemsToCart beverages;

	@BeforeMethod(alwaysRun = true)
	public void pageSetup() {

		beverages = new AddItemsToCart(driver);

	}

	@Test(dependsOnMethods = "testCases.MenuItemsTest.items", groups = { "singleuser" })
	public void addingToCart() throws InterruptedException {

		log.info("ADDING THE FOLLOWING ITEMS TO CART:");

		beverages.addingItems();

		String finalPrice = beverages.totalCost();

		String expectedPrice = "Total: $33.00";

		if (!finalPrice.equals(expectedPrice)) {

			log.error("The total cost is incorrect. Expected: " + expectedPrice + " But found: " + finalPrice);

		}

		Assert.assertEquals(finalPrice, expectedPrice, "The total cost is incorrect");

		String proTxt = beverages.promoText();

		String actualProText = "It's your lucky day! Get an extra cup of Mocha for $4.";

		if (!proTxt.equals(actualProText)) {

			log.error("The promotion offer text is not matching as intended. Expected: " + actualProText
					+ " But found: " + proTxt);
		}

		Assert.assertEquals(proTxt, actualProText, "The promotion text does not match");

		String updatedCost = beverages.acceptPromoOffer();

		String expectedNewCost = "Total: $37.00";

		if (!updatedCost.equals(expectedNewCost)) {

			log.error("The new updated price does not match. Expected: " + expectedNewCost + " But found: "
					+ updatedCost);

		}

		Assert.assertEquals(updatedCost, expectedNewCost, "The updated price is incorrect");

	}

}
