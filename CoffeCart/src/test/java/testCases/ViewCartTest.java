package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pom.AddItemsToCart;
import pom.ViewCart;

public class ViewCartTest extends BaseTest {

	ViewCart cart;

	@BeforeMethod
	public void pageSetup() {

		cart = new ViewCart(driver, wait);

	}

}
