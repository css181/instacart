package com.instacart;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.mySelenium.framework.SeleniumBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlaceOrderPage extends SeleniumBasePage {

	private static final By placeOrderButton = By.xpath("//section//button[@type='button']");
	
	public PlaceOrderPage(WebDriver driver) {
		super(driver);
	}

	@Override
	protected By getMainElement() {
		return placeOrderButton;
	}

	public void placeOrder() {
		actions.click(placeOrderButton);
		Logger.getAnonymousLogger().log(Level.INFO, "SUCCESSFULLY placed order on instacart!");
	}
}
