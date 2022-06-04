package org.mySelenium.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class SeleniumPageObject {

	protected WebDriver driver;
	protected SeleniumElementFinder finder;
	protected SeleniumActionMethods actions;
	
	public SeleniumPageObject(WebDriver driver) {
		super();
		this.driver = driver;
		this.finder = new SeleniumElementFinder(driver);
		this.actions = new SeleniumActionMethods(driver, finder, this.getClass().getSimpleName());
	}

	protected abstract By getMainElement();
	public boolean isLoaded() {
		if(finder.getElement(getMainElement(), 10) != null) { //Wait up to 10 seconds
			return true;
		}
		return false;
	}
}