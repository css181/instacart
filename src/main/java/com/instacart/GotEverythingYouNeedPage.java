package com.instacart;


import org.mySelenium.framework.SeleniumBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GotEverythingYouNeedPage extends SeleniumBasePage {

	private static final By continueToCheckoutButton = By.xpath("//span[@class='css-1ohhyoe']");
	
	public GotEverythingYouNeedPage(WebDriver driver) {
		super(driver);
	}

	@Override
	protected By getMainElement() {
		return continueToCheckoutButton;
	}

	public CheckoutPage gotToCheckout() {
		actions.click(continueToCheckoutButton);
		return new CheckoutPage(driver);
	}
}
