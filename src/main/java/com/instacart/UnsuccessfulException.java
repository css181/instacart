package com.instacart;

import org.mySelenium.framework.ScreenshotUtility;
import org.openqa.selenium.WebDriver;

public class UnsuccessfulException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UnsuccessfulException(String message, WebDriver driver) {
		super(message);
		ScreenshotUtility.takeScreenshot(message, driver);
	}

}