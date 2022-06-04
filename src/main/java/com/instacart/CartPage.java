package com.instacart;

import org.mySelenium.framework.SeleniumBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends SeleniumBasePage {

	private static final By goToCheckoutButton = By.xpath("//a[@tabindex='0']");
	
	public CartPage(WebDriver driver) {
		super(driver);
	}

	@Override
	protected By getMainElement() {
		return goToCheckoutButton;
	}

	public GotEverythingYouNeedPage gotToGotEverythingYouNeed() {
		actions.click(goToCheckoutButton);
		return new GotEverythingYouNeedPage(driver);
	}
}
