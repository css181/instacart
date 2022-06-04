package org.mySelenium.framework;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;

public class ErrorHandler {
	private static final String SELENIUM_FAIL_IF_NOT_FOUND_PROPERTY = "failIfElementNotFound";
	protected static final int stacktraceDepthOffset = 2; //Depth:0="StackTrace", Depth:1="getMethodNameFromStackTrace"
	
	protected void throwOrLogError(WebDriver driver, final String locator, final String action, String pageName) {
		throw new CouldNotTakeActionOnElementException(locator, pageName, action, driver);
	}
	protected void logNullElementWarning(final String locator, final String action, String pageName) {
		Logger.getAnonymousLogger().warning(CouldNotTakeActionOnElementException.getMessage(locator, pageName, action));
	}
	protected String getMethodNameFromStackTrace(final int depth) {
		String returnVal = "";
		try{
			returnVal = Thread.currentThread().getStackTrace()[depth].getMethodName();
		} catch(Exception e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "Can not get method name from stacktrace.  Error details:");
			Logger.getAnonymousLogger().log(Level.SEVERE, e.getMessage());
		}
		return returnVal;
	}
}