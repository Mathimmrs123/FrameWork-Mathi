package com.omrbranch.day18;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCardPage extends BaseClass {
	
	public MyCardPage() {
     PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(id="address_type")
	private WebElement txtAddress;
	
	@FindBy(name="first_name")
	private WebElement txtFirstName;
	
	@FindBy(name="last_name")
	private WebElement txtLastName;
	
	@FindBy(name="mobile")
	private WebElement txtContact;
	
	@FindBy(name="apartment")
	private WebElement txtHouseNo;

	@FindBy(className="form-control height50")
	private WebElement txtaddress;
	
	@FindBy(name="state")
	private WebElement txtState;
	
	@FindBy(name="city")
	private WebElement txtCity;
	
	@FindBy(name="zipcode")
	private WebElement txtZipcode;
	
	@FindBy(xpath = "(//button[text()='Save'])[1]")
	private WebElement btnSave;

	public WebElement getBtnSave() {
		return btnSave;
	}


	public WebElement getAddressType() {
		return txtAddress;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtContact() {
		return txtContact;
	}

	public WebElement getTxtHouseNo() {
		return txtHouseNo;
	}

	public WebElement getTxtaddress() {
		return txtaddress;
	}

	public WebElement getTxtState() {
		return txtState;
	}

	public WebElement getTxtCity() {
		return txtCity;
	}

	public WebElement getTxtZipcode() {
		return txtZipcode;
	}
	
	public void addDeliveryAdddress(String addressType,String firstName,String lastName,String contactNum,String houseNum,String fullAddress,String state,String city,String zipcode ) {
		
		elementSendKeysJs(txtAddress, addressType);
		elementSendKeys(txtFirstName, firstName);
		elementSendKeys(txtLastName, lastName);
		elementSendKeys(txtContact, contactNum);
		elementSendKeys(txtHouseNo, houseNum);
		elementSendKeys(txtAddress, fullAddress);
		elementSendKeysJs(txtState, state);
		elementSendKeysJs(txtCity, city);
		elementSendKeysJs(txtZipcode, zipcode);
		elementClick(btnSave);
	}

		
	
}
