package pom;

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
 * Page Object Model for the main menu page, this is where users can view and
 * add coffee items to their cart. This class includes all WebElements and
 * methods needed in order to interact with items. In addition to verifying the
 * total cost and promotional offers which are available.
 */
public class AddItemsToCart extends BasePage {

	private static final Logger log = LogManager.getLogger(AddItemsToCart.class.getName());

	public AddItemsToCart(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@aria-label='Espresso']")
	WebElement espresso;

	@FindBy(xpath = "//div[@aria-label='Mocha']")
	WebElement mocha;

	@FindBy(css = "div[aria-label='Cafe Breve']")
	WebElement cafeBreve;

	@FindBy(css = "button[aria-label='Proceed to checkout']")
	WebElement cost;

	@FindBy(xpath = "//div[@class='promo']//span[1]")
	WebElement promoTxt;

	@FindBy(css = ".yes")
	WebElement yes;

	@FindBy(xpath = "//div[@class='promo']//button[2]")
	WebElement no;

	/**
	 * A set of items from the menu is added to the cart (Espresso, Mocha, Cafe
	 * Breve).
	 */
	public void addingItems() {

		log.debug("Clicking on Espresso");
		clickElement(espresso);

		log.debug("Clicking on Mocha");
		clickElement(mocha);

		log.debug("Clicking on Cafe Breve");
		clickElement(cafeBreve);

	}

	/**
	 * Gathers the total cost from the cart.
	 * 
	 * @return The final amount is then returned and formatted in a String.
	 */
	public String totalCost() {

		wait.until(ExpectedConditions.visibilityOf(cost));
		String amount = cost.getText();
		log.info("Cost of Beverages Added To Basket:" + " " + amount);
		return amount;

	}

	/**
	 * Wait for the promotional text to appear and retrieve the text.
	 * 
	 * @return The text is returned and formatted in a String which can be used to
	 *         Assert.
	 */
	public String promoText() {

		wait.until(ExpectedConditions.visibilityOf(promoTxt));
		String offer = promoTxt.getText();
		return offer;

	}

	/**
	 * Accepting the promotional offer and then obtaining the new total cost
	 * 
	 * @return New amount is then returned and formatted in a String
	 */
	public String acceptPromoOffer() {

		wait.until(ExpectedConditions.visibilityOf(yes));
		log.info("ACCEPTING THE PROMOTIONAL OFFER");
		clickElement(yes);
		String newAmount = cost.getText();
		log.info("New cost of Beverages after adding promo offer:" + " " + newAmount);
		return newAmount;

	}

	/**
	 * Waiting for the promotional offer to appear but this time declining it.
	 */
	public void declinePromoOffer() {

		wait.until(ExpectedConditions.visibilityOf(no));

		clickElement(no);

	}

}
