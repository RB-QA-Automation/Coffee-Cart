package testCases;

import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import base.BaseTest;
import pom.AddItemsToCart;

public class AddItemsToCartTest extends BaseTest {

	AddItemsToCart beverages;

	@BeforeMethod
	public void pageSetup() {

		beverages = new AddItemsToCart(driver);
	}

	@Test(dependsOnMethods = "testCases.MenuItemsTest.items")
	public void addingToCart() throws InterruptedException {

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

	}

}
