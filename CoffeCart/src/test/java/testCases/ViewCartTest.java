package testCases;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import base.BaseTest;
import pom.ViewCart;

public class ViewCartTest extends BaseTest {

	private static final Logger log = LogManager.getLogger(ViewCartTest.class.getName());

	ViewCart cart;

	@BeforeMethod(alwaysRun = true)
	public void pageSetup() {

		cart = new ViewCart(driver);

	}

	@Test(dependsOnMethods = "testCases.AddItemsToCartTest.addingToCart", groups = { "singleuser" })

	public void updatedCart() throws InterruptedException {

		log.info("Viewing cart and verifying final items");

		String currentPriceDisplayed = cart.currentTotal();

		String currentExpected = "Total: $37.00";

		if (!currentPriceDisplayed.equals(currentExpected)) {

			log.error("Price displayed is incorrect. Expected: " + currentExpected + "But found: "
					+ currentPriceDisplayed);
		}

		Assert.assertEquals(currentPriceDisplayed, currentExpected);

		log.info("Adding and removing items from the basket");

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
