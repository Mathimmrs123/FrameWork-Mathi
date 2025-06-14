package com.omrbranch.day18;

import java.io.IOException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;




public class GroceryTask1 extends BaseClass {
	
	@BeforeClass
	public static void beforeclass() {
		
		browserLaunch("CHROME");
		enterApplnUrl("https://www.omrbranch.com/");
		maximizeWindow();
		implicitWait();
	}
	@AfterClass
	public static void afterclass() {
		//closeWindow();
	}
	
	@Test
	
	public void login() throws IOException, InterruptedException {

		LoginePage page=new LoginePage();
		page.login(getCellData("omr", 1, 0),getCellData("omr", 1, 1));
		
		SearchProductPage productSearch=new SearchProductPage();
		
//		navigateRefresh("https://www.omrbranch.com/#");
		Thread.sleep(2000);
	productSearch.ProductSearchBox(getCellData("omr", 1, 2));
	
	
	ProductListingPage ProductListingPage=new ProductListingPage();
	
	ProductListingPage.addProductList();
	Thread.sleep(1000);
	MyCardPage addressDetails=new MyCardPage();
	addressDetails.addDeliveryAdddress(getCellData("omr", 1, 3),getCellData("omr", 1, 4),getCellData("omr", 1, 5),getCellData("omr", 1, 6),getCellData("omr", 1, 7),getCellData("omr", 1, 8),getCellData("omr", 1, 9),getCellData("omr", 1, 10),getCellData("omr", 1, 11));
	
	
	}
}
