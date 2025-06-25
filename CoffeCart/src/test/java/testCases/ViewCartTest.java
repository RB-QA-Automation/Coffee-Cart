package testCases;

import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import base.BaseTest;
import pom.ViewCart;

public class ViewCartTest extends BaseTest {

	ViewCart cart;

	@BeforeMethod(alwaysRun = true)
	public void pageSetup() {

		cart = new ViewCart(driver);

	}

	@Test(dependsOnMethods = "testCases.AddItemsToCartTest.addingToCart", groups = { "singleuser" })

	public void updatedCart() throws InterruptedException {

		String currentPriceDisplayed = cart.currentTotal();

		String currentExpected = "Total: $37.00";

		Assert.assertEquals(currentPriceDisplayed, currentExpected);

		cart.addAndRemove();

		String finalPrice = cart.finalTotal();

		String finalExpected = "Total: $44.00";

		Assert.assertEquals(finalPrice, finalExpected);

		cart.finalItems();

	}

}
