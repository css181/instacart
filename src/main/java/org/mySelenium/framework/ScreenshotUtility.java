package org.mySelenium.framework;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

	public static final String SCREENSHOT_FILE_LOCATION = "src/test/resources";
	
	/**
	 * Attempts to take a screenshot of the currently active browser.  If unsuccessful an error message is displayed in the console but the test will continue.
	 * @param message - The filename will contain a camelCase version of the message + a time stamp.
	 * @param driver
	 */
	public static void takeScreenshot(String message, WebDriver driver) {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String newFileName = StringHelperUtil.camelCase(message, true) + "__" + getTimeStamp(new Date()) + ".png";
		try {
			file.renameTo(new File(SCREENSHOT_FILE_LOCATION + "/" + newFileName));
		} catch (Exception e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "SCREENSHOT NOT TAKEN.  The following error occured when trying to take a screenshot.");
			Logger.getAnonymousLogger().log(Level.SEVERE, e.getMessage());
		}
	}
	
	static String getTimeStamp(Date date) {
		return new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(date);
	}

}