package com.cognixia.training.MavenTestNGSelenium.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FlipkartWorkflowTest extends TestNGBase {
	
	@Test
	public void testFlipkartWorkflow() {
		
		SoftAssert soft_assert = new SoftAssert();
		
		searchForProduct("fitbit");
		
		displayResultsBetweenRange("5000", "20000");
		int actual_no_of_results = 0;
		soft_assert.assertTrue(actual_no_of_results > 900); //Assertion should not be inside method
				
		clickFirstLink();
		takeScreenshot("/screenshots/ProductDetailsPage.jpg");
		String discountedprice = calculateDiscountedPrice();
		String actualprice = null;
		soft_assert.assertEquals(discountedprice, actualprice);
		
		addtoCart();
		
		String totalamount = null;
		soft_assert.assertEquals(totalamount, discountedprice);
		
		soft_assert.assertAll();
	}

	private String calculateDiscountedPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	private void addtoCart() {
		// TODO Auto-generated method stub
		
	}

	private void takeScreenshot(String string) {
		// TODO Auto-generated method stub
		
	}

	private void clickFirstLink() {
		// TODO Auto-generated method stub
		
	}

	private void displayResultsBetweenRange(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

	private void searchForProduct(String string) {
		// TODO Auto-generated method stub
		
	}
}
