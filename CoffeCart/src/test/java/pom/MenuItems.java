package pom;

import java.util.ArrayList;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BasePage;

/**
 * Page Object Model class iterates through all the items listed on the
 * Menu page, including coffee name and price,
 */

public class MenuItems extends BasePage {

	private static final Logger log = LogManager.getLogger(MenuItems.class.getName());

	public MenuItems(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "li > h4")
	public List<WebElement> coffees;

	public List<String> coffeeNames() {

		List<String> names = new ArrayList<>();

		for (WebElement nmes : coffees) {

			String itemsList = nmes.getText().replace("\n", " ");

			names.add(itemsList);

			log.info("Coffee Menu: " + " " + itemsList);

		}

		return names;

	}

}
