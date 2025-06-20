package pom;

import java.util.ArrayList;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BasePage;

public class MenuItems extends BasePage{


	public MenuItems(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(tagName = "h4")
	public List<WebElement> coffees;

	public List<String> coffeeNames() {

		List<String> names = new ArrayList<>();

		for (WebElement nmes : coffees) {

			String itemsList = nmes.getText();

			names.add(itemsList);

			System.out.println(itemsList);

		}

		return names;

	}

}
