package com.instacart.tests;

import org.junit.Test;

import com.instacart.CartPage;
import com.instacart.CheckoutPage;
import com.instacart.CostcoResultsPage;
import com.instacart.GotEverythingYouNeedPage;
import com.instacart.HomePage;
import com.instacart.PlaceOrderPage;
import com.instacart.ResultsPage;

public class MainTest extends BaseTest {

	//Checkout page will verify delivering to this address or will throw exception.
	String addressLine1 = "Input Your Line1 Address Here"; //Change to your address

	@Test
	public void test() {
		HomePage home = new HomePage(driver);
		home.launchHomePage();
		ResultsPage results = home.searchForItem("Kirkland Formula");
		CostcoResultsPage costco = results.goToViewAllCostcoItems();
		costco.addIfAnyContainString("Formula");
		CartPage cart = costco.gotToCart();
		GotEverythingYouNeedPage gotEverything = cart.gotToGotEverythingYouNeed();
		CheckoutPage checkout = gotEverything.gotToCheckout();
		PlaceOrderPage placeOrder = checkout.submitPurchase(addressLine1);
		
		//Uncomment to actually place the order.
		//Leaving this commented so we don't actually charge credit cards.
//		placeOrder.placeOrder();
		
		System.out.println("SUCCESSFULLY MADE IT THROUGH THE ENTIRE TEST.  ORDER HAS BEEN PLACED");
	}

}
