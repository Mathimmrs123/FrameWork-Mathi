package com.omrbranch.day18;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 extends BaseClass {
	
	public void Login() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement snduser;

	@FindBy(id = "password")
	private WebElement sndpass;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-login btn-login-padding']")
	private WebElement clklog;

	@FindBy(xpath = "//a[contains(text(),' Forgot username or password?')]")
	private WebElement clkforgetpass;

	@FindBy(xpath = "//button[contains(text(),'Send Reset Link')]")
	private WebElement clkresetbutt;

	public WebElement getSnduser() {
		return snduser;
	}

	public WebElement getSndpass() {
		return sndpass;
	}

	public WebElement getClklog() {
		return clklog;
	}

	public WebElement getClkforgetpass() {
		return clkforgetpass;
	}

	public WebElement getClkresetbutt() {
		return clkresetbutt;
	}


}
