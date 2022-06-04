package com.instacart;

import java.util.List;

import org.mySelenium.framework.SeleniumBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CostcoResultsPage extends SeleniumBasePage {

	private static final By allCostcoItemsMatchingSearch = By.xpath("//div[@id='store-wrapper']/div/div/div[2]/ul");
	private static final By viewCartButton = By.xpath("//div[@id='commonHeader']/div[2]/button");
	
	public CostcoResultsPage(WebDriver driver) {
		super(driver);
	}

	@Override
	protected By getMainElement() {
		return allCostcoItemsMatchingSearch;
	}

	public void addIfAnyContainString(String matchString) {
		boolean foundFormula = false;
		try {
			Thread.sleep(2000);//Wait for page to fully load.  Instacart has nothing good to wait for
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> allItems = finder.getSubElements(allCostcoItemsMatchingSearch, By.xpath("//li"));
		for (WebElement item : allItems) {
			String itemText = actions.getText(item);
			if(itemText.toUpperCase().contains(matchString.toUpperCase())) {
				foundFormula = true;
				actions.click(finder.getSubElement(item, By.xpath("//button"))); //Adds 1
				actions.click(finder.getSubElement(item, By.xpath("//button[@class='css-4mkak5']"), 3)); //Adds a second after waiting up to 3 seconds for "+" to appear
				break;
			}
		}
		if(!foundFormula) {
			throw new UnsuccessfulException("Costco does not currently have any " + matchString + " for sale", driver);
		}
	}
	
	public CartPage gotToCart() {
		actions.click(viewCartButton);
		return new CartPage(driver);
	}
}
