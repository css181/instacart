package com.instacart;


import org.mySelenium.framework.SeleniumBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends SeleniumBasePage {

	private static final By line1Address = By.xpath("//h2");
	private static final By continueDeliveryTimeButton = By.xpath("//div[@id='Delivery-time-chooser']/../button[1]");
	private static final By continueDeliveryInstructionsButton = By.xpath("//form//button");
	private static final By saveMobileNumberButton = By.xpath("//div[@id='Mobile-number-chooser']/form//button[@type='submit']");
	private static final By continueToReviewAndSubmitButton = By.xpath("//button[@aria-live='polite']");
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	@Override
	protected By getMainElement() {
		return line1Address;
	}

	public PlaceOrderPage submitPurchase(String addressLine1Verification) {
		clickContinueDeliveryTime(addressLine1Verification);
		clickContinueDeliveryInstructions();
		clickSaveMobileNumber();
		clickToReviewAndSubmit();
		return new PlaceOrderPage(driver);
	}
	

	private void clickContinueDeliveryTime(String addressLine1Verification) {
		if(!actions.getText(line1Address).toUpperCase().contains(addressLine1Verification.toUpperCase()) ) {
			throw new UnsuccessfulException("Address Line 1 did not match on Checkout Page.  Not proceeding to purchase.", driver);
		}
		actions.click(continueDeliveryTimeButton);
	}
	private void clickContinueDeliveryInstructions() {
		actions.click(continueDeliveryInstructionsButton);
	}
	private void clickSaveMobileNumber() {
		actions.click(saveMobileNumberButton);
	}
	private void clickToReviewAndSubmit() {
		actions.click(continueToReviewAndSubmitButton);
	}
	
}
