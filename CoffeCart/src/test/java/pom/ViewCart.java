package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class ViewCart extends BasePage {

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

		cartBtn.click();
		String cartTotal = amount.getText();
		System.out.println("Current total cost in cart is:" + " " + cartTotal);
		return cartTotal;

	}

	public void addAndRemove() {

		addCafeBreve.click();
		removeMocha.click();

	}

	public String finalTotal() {

		String finalCost = amount.getText();
		System.out.println("Final total cost is:" + " " + finalCost);
		return finalCost;

	}

	public String finalItems() {

		for (int i = 0; i < items.size(); i++) {

			String lastOrder = items.get(i).getText();
			allItemsTxt.append(lastOrder);
			System.out.println("Final Orders:" + " " + lastOrder);
		}
		return allItemsTxt.toString();

	}

}
