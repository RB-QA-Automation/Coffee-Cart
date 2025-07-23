package testCases;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import base.BaseTest;
import pom.ViewCart;

/**
 * Test Case which verifies the final items in the basket and also final cost.
 * Test includes assertions for the current price displayed against the current
 * expected price, and also final price against final expected price.
 */
public class ViewCartTest extends BaseTest {

	private static final Logger log = LogManager.getLogger(ViewCartTest.class.getName());

	ViewCart cart;

	/**
	 * Initializes the ViewCart page object before each of the test cases are ran.
	 */
	@BeforeMethod(alwaysRun = true)
	public void pageSetup() {

		cart = new ViewCart(driver);

	}

	/**
	 * A test which checks the final cost of the items in the cart, in addition to
	 * adding and removing items.
	 * 
	 * @throws InterruptedException only if the thread is interrupted.
	 */
	@Test(dependsOnMethods = "testCases.AddItemsToCartTest.addingToCart", groups = { "singleuser" })

	public void updatedCart() throws InterruptedException {

		log.info("VIEWING CART AND VERIFYING FINAL ITEMS:");

		String currentPriceDisplayed = cart.currentTotal();

		String currentExpected = "Total: $37.00";

		if (!currentPriceDisplayed.equals(currentExpected)) {

			log.error("Price displayed is incorrect. Expected: " + currentExpected + " But found: "
					+ currentPriceDisplayed);
		}

		Assert.assertEquals(currentPriceDisplayed, currentExpected);

		log.info("ADDING AND REMOVING ITEMS FROM THE BASKET:");

		cart.addAndRemove();

		String finalPrice = cart.finalTotal();

		String finalExpected = "Total: $44.00";

		if (!finalPrice.equals(finalExpected)) {

			log.error("Final cost of items is incorrect. Expected: " + finalExpected + "But found: " + finalPrice);
		}

		Assert.assertEquals(finalPrice, finalExpected);

		cart.finalItems();

	}

}
