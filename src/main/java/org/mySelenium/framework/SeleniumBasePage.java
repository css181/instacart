package org.mySelenium.framework;

import org.openqa.selenium.WebDriver;

public abstract class SeleniumBasePage extends SeleniumPageObject{
	
	public SeleniumBasePage(WebDriver driver) {
		super(driver);
		if(!isLoaded()) {
			throw new SeleniumNavigationException("Page " + this.getClass().getSimpleName() + 
					" was not loaded in the browser when trying to construct the object.", driver);
		}
	}

}