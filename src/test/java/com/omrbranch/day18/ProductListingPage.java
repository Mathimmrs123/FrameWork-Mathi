package com.omrbranch.day18;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListingPage extends BaseClass {
	
	public ProductListingPage() {
    PageFactory.initElements(driver,this);	
    }
	
	@FindBy(xpath = "(//a[text()='Add'])[1]")
	private WebElement btnAdd;
	
	@FindBy(id="cart-22")
	private WebElement btnPaticularProduct;
	
	@FindBy(xpath = "(//a[text()=' Go To Cart '])")
	private WebElement btnAddToCard;
	

	@FindBy(xpath = "//div[contains(@class,'diffAddres ')]")
	private WebElement btnDileveryAddress;
	
	public WebElement getBtnDileveryAddress() {
		return btnDileveryAddress;
	}

	public WebElement getBtnAdd() {
		return btnAdd;
	}

	public WebElement getBtnPaticularProduct() {
		return btnPaticularProduct;
	}

	public WebElement getBtnAddToCard() {
		return btnAddToCard;
	}
	
	public void addProductList() {
		elementClick(btnAdd);
		elementClick(btnPaticularProduct);
		elementClickJs(btnAddToCard);
		elementClickJs(btnDileveryAddress);
	}
	
	
}
