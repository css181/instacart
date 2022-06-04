package org.mySelenium.framework;

import org.openqa.selenium.WebDriver;

public abstract class SeleniumStartPage extends SeleniumPageObject{
	
	public SeleniumStartPage(WebDriver driver) {
		super(driver);
	}

	public abstract String getPageUrl();
	
	public void navigateToPage() {
		driver.get(getPageUrl());
		if(!isLoaded()) {
			throw new SeleniumNavigationException("Page " + this.getClass().getSimpleName() + 
					" was determined to not be loaded after navigating to " + getPageUrl(), driver);
		}
	}
	
}