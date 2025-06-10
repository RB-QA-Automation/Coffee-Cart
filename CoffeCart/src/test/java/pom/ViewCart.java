package pom;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewCart {

	private WebDriverWait wait;

	public ViewCart(WebDriver driver, WebDriverWait wait) {

		PageFactory.initElements(driver, this);
		this.wait = wait;

	}
	
	

	

}
