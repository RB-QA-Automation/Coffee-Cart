package pom;

import java.util.ArrayList;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class AddItemsToCart extends BaseTest {

	public AddItemsToCart(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@aria-label='Espresso']")
	WebElement espresso;

	@FindBy(xpath = "//div[@aria-label='Mocha']")
	WebElement mocha;

	@FindBy(css = "div[aria-label='Cafe Breve']")
	WebElement cafeBreve;

	public void addingItems() throws InterruptedException {

		espresso.click();
		Thread.sleep(3000);
		mocha.click();
		Thread.sleep(3000);
		cafeBreve.click();

	}

}
