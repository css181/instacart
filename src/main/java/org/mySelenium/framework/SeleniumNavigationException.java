package org.mySelenium.framework;

import org.openqa.selenium.WebDriver;

public class SeleniumNavigationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final String defaultMessage = "Could not load Page";

	public SeleniumNavigationException(WebDriver driver) {
		super(defaultMessage);
		ScreenshotUtility.takeScreenshot(defaultMessage, driver);
	}
	
	public SeleniumNavigationException(String message, WebDriver driver) {
		super(message);
		ScreenshotUtility.takeScreenshot(message, driver);
	}

}
