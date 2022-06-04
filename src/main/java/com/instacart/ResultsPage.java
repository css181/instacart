package com.instacart;

import java.util.List;

import org.mySelenium.framework.CouldNotTakeActionOnElementException;
import org.mySelenium.framework.SeleniumBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultsPage extends SeleniumBasePage {

	private static final By allResultsWindow = By.xpath("//div[@id='store-wrapper']/div/div/ul");
	
	public ResultsPage(WebDriver driver) {
		super(driver);
	}

	@Override
	protected By getMainElement() {
		return allResultsWindow;
	}

	public CostcoResultsPage goToViewAllCostcoItems() {
		List<WebElement> allStores = finder.getSubElements(allResultsWindow, By.xpath("//li"));
		for (WebElement store : allStores) {
			String storeName = actions.getText(finder.getSubElement(store, By.xpath("//div/a/div[2]")));
			if(storeName.contains("Costco")) {
				actions.click(finder.getSubElement(store, By.xpath("//div/a/div[3]/span")));
				return new CostcoResultsPage(driver);
			}
		}
		throw new CouldNotTakeActionOnElementException("allResultsWindow", this.getClass().getSimpleName(), "click to view all Costco results", driver);
	}

}
