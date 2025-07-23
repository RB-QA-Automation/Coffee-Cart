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

/**
 * Page Object Model for viewing the users final list of items. Class contains
 * elements which process the flow of viewing cart, in addition to adding more
 * items The current cost is highlighted in addition to the final cost which is
 * displayed at the end, a final item list is then provided.
 */

public class ViewCart extends BasePage {

	private static final Logger log = LogManager.getLogger(ViewCart.class.getName());

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

	/**
	 * Clicking on cart and viewing total amount.
	 * 
	 * @return Storing total in String object.
	 */
	public String currentTotal() {

		log.debug("Clicking on cart button");
		clickElement(cartBtn);

		String cartTotal = amount.getText();
		log.info("Current total cost in cart is:" + " " + cartTotal);
		return cartTotal;

	}

	/**
	 * Adding and removing items from the cart which updates the basket.
	 */
	public void addAndRemove() {

		log.debug("Adding a Cafe Breve to basket");
		clickElement(addCafeBreve);

		log.debug("Removing Mocha from basket");
		clickElement(removeMocha);

	}

	/**
	 * A final total is then calculated.
	 * 
	 * @return Final cost is stored in a String variable.
	 */
	public String finalTotal() {

		String finalCost = amount.getText();
		log.info("Final total cost is:" + " " + finalCost);
		return finalCost;

	}

	/**
	 * The final list of items is then iterated through with the coffee names.
	 * 
	 * @return Final coffee list.
	 */
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
