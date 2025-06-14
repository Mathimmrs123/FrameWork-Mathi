package com.omrbranch.day18;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginePage extends BaseClass {
	
	public LoginePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="email")
private WebElement txtEmail;
	
	@FindBy(id="pass")
	private WebElement txtPass;
	
	@FindBy(xpath="//button[text()='Login']")
	private WebElement btnLogine;

	
	

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getTxtPass() {
		return txtPass;
	}

	public WebElement getBtnLogine() {
		return btnLogine;
	}
	
	public void login(String emaild,String password) {
		elementSendKeys(txtEmail, emaild);
		elementSendKeys(txtPass, password);
		elementClick(btnLogine);
		

	}
	

}
