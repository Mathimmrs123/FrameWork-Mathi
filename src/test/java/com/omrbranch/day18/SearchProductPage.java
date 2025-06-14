package com.omrbranch.day18;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProductPage extends BaseClass {
	
	public SearchProductPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="search")
	private WebElement txtProductsearch;
	
	public WebElement getTxtProductsearch() {
		return txtProductsearch;
	}
	public void ProductSearchBox(String productName) {
		elementSendkeysEnter(txtProductsearch, productName);
	}
	
	

     
     
     
     
     
     
     
     
     
     
     
     
     
     
		
     
}
