package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddItemsToCart {

	private WebDriverWait wait;

	public AddItemsToCart(WebDriver driver, WebDriverWait wait) {

		PageFactory.initElements(driver, this);
		this.wait = wait;

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

	public void addingItems() throws InterruptedException {

		espresso.click();
		mocha.click();
		cafeBreve.click();

	}

	public String totalCost() {

		wait.until(ExpectedConditions.visibilityOf(cost));
		String amount = cost.getText();
		System.out.println("Cost of Beverages:" + " " + amount);
		return amount;

	}

	public String promoText() {

		wait.until(ExpectedConditions.visibilityOf(promoTxt));
		String offer = promoTxt.getText();
		return offer;

	}

	public String acceptPromoOffer() {

		wait.until(ExpectedConditions.visibilityOf(yes));
		yes.click();
		String newAmount = cost.getText();
		System.out.println("New cost of Beverages after adding promo offer:" + " " + newAmount);
		return newAmount;

	}

	public void declinePromoOffer() {

		wait.until(ExpectedConditions.visibilityOf(no));
		no.click();

	}

}
