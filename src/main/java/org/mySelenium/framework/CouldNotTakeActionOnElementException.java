package org.mySelenium.framework;

import org.openqa.selenium.WebDriver;

public class CouldNotTakeActionOnElementException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public CouldNotTakeActionOnElementException(String locator, String page, String action, WebDriver driver) {
		super(getMessage(locator, page, action));
		ScreenshotUtility.takeScreenshot(getMessage(locator, page, action), driver);
	}

	public static String getMessage(String locator, String page, String action) {
		return "Element could not be found. Locator: " + locator + ", on Page: " + page + ", while trying to take action: " + action;
	}

}