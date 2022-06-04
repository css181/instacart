package com.instacart;

import org.mySelenium.framework.SeleniumNavigationException;
import org.mySelenium.framework.SeleniumStartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends SeleniumStartPage {

	private static final By searchBar = By.className("css-1smea13-SearchBarInput");
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public String getPageUrl() {
		return "https://www.instacart.com/store?"; //Update to use URL with logged in creds
	}

	@Override
	protected By getMainElement() {
		return searchBar;
	}
	
	@Override
	public boolean isLoaded() {
		if(finder.getElement(getMainElement(), 20) != null) { //Wait up to 20 seconds
			return true;
		}
		return false;
	}

	public void launchHomePage() {
		driver.get(getPageUrl());
		
		//If you can't get URL with creds, use this to sign in:
//		actions.type("Enter User Name Here", By.xpath("//input[@type='email']"));
//		actions.type("Enter Password Here", By.xpath("//input[@type='password']"));
//		actions.click(By.xpath("//button[@type='submit']"));
		
		
		if(!isLoaded()) {
			throw new SeleniumNavigationException("Page " + this.getClass().getSimpleName() + 
					" was determined to not be loaded after navigating to " + getPageUrl(), driver);
		}
	}
	
	public ResultsPage searchForItem(String itemName) {
		actions.type(itemName, searchBar);
		actions.type(Keys.ENTER, searchBar);
		return new ResultsPage(driver);
	}

}
