package org.mySelenium.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class FluentWaitGenerator {
	protected FluentWait<WebDriver> getFluentWait(WebDriver driver, int maxTimeInSec) {
		return new FluentWait<WebDriver>(driver)    
			    .withTimeout(maxTimeInSec, TimeUnit.SECONDS)    
			    .pollingEvery(100, TimeUnit.MILLISECONDS)   
			    .ignoring(NoSuchElementException.class);
	}
	
	protected FluentWait<WebDriver> getFluentWait(WebDriver driver, int pollingInMilliseconds, Class<? extends Throwable> classToIgnore, int maxTimeInSec) {
		return new FluentWait<WebDriver>(driver)    
			    .withTimeout(maxTimeInSec, TimeUnit.SECONDS)    
			    .pollingEvery(pollingInMilliseconds, TimeUnit.MILLISECONDS)   
			    .ignoring(classToIgnore);
	}
}
