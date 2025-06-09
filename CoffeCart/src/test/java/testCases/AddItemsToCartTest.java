package testCases;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pom.AddItemsToCart;
import pom.MenuItems;

public class AddItemsToCartTest extends BaseTest {

	AddItemsToCart beverages;

	@BeforeMethod
	public void pageSetup() {

		beverages = new AddItemsToCart(driver);
	}

	@Test
	public void addingItems() throws InterruptedException {

		beverages.addingItems();

	}

}
