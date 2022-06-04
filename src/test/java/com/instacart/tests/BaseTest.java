package com.instacart.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    
	/** Headless or DemoMode which will highlight elements as they're being enacted on **/
	private static final boolean HEADLESS_MODE = false;
	
	protected WebDriver driver;
	private ChromeOptions options;
	private static final String chromeDriverLocation = "src\\test\\recources\\chromedriver.exe";
	
	@Before
	public void baseTestSetup() {
		setUpChromeDriverOptions();
		launchTheBrowser();
	}

	void setUpChromeDriverOptions() {
	    System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
	    options = new ChromeOptions();
	    if(HEADLESS_MODE) {
	    	options.addArguments("--headless");
	    	System.setProperty("SELENIUM_DEMO_MODE", "false");
	    } else {
		    //Setting to true will highlight elements for 2 seconds just before they're acted on.
		    System.setProperty("SELENIUM_DEMO_MODE", "true");
	    }
	    
	    options.addArguments("--disable-gpu");
	    options.addArguments("--window-size=1400,800");  

	}
	
	private void launchTheBrowser() {
	    driver = new ChromeDriver(options);   
	}
	
	@After
	public void baseTestTeardown() {
		if(driver != null) {
			driver.quit();
		}
	}
	
}
