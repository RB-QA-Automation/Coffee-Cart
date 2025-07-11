package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class ViewCart extends BasePage {

	private static final Logger log = LogManager.getLogger(AddItemsToCart.class.getName());

	public ViewCart(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);

	}

	StringBuilder allItemsTxt = new StringBuilder();

	@FindBy(css = "a[aria-label='Cart page']")
	WebElement cartBtn;

	@FindBy(xpath = "//button[@aria-label='Proceed to checkout']")
	WebElement amount;

	@FindBy(css = "li[class='list-item'] div div[class='unit-controller'] button[aria-label='Add one Cafe Breve']")
	WebElement addCafeBreve;

	@FindBy(css = "button[aria-label='Remove all Mocha']")
	WebElement removeMocha;

	@FindBy(css = "li[class$='list-item'] div:nth-child(1)")
	List<WebElement> items;

	public String currentTotal() {

		log.debug("Clicking on cart button");
		cartBtn.click();
		
		String cartTotal = amount.getText();
		log.info("Current total cost in cart is:" + " " + cartTotal);
		System.out.println("--------------------------------------------------");
		return cartTotal;

	}

	public void addAndRemove() {

	    log.debug("Adding a Cafe Breve to basket");
		addCafeBreve.click();
		
		log.debug("Removing Mocha from basket");
		removeMocha.click();

	}

	public String finalTotal() {

		String finalCost = amount.getText();
		log.info("Final total cost is:" + " " + finalCost);
		System.out.println("--------------------------------------------------");
		return finalCost;

	}

	public String finalItems() {

		for (int i = 0; i < items.size(); i++) {

			String lastOrder = items.get(i).getText();

			if (lastOrder != null && !lastOrder.trim().isEmpty()) {

				allItemsTxt.append(lastOrder);
				log.info("Final Orders:" + " " + lastOrder);

			}

		}

		return allItemsTxt.toString();

	}

}
