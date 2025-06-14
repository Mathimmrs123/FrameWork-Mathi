package com.omrbranch.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.omrbranch.day18.LoginePage;

public class OmrBranchTestNg extends BaseClass{
	
	@AfterClass
	private void afterClass() {

		browserLaunch("CHROME");
		enterApplnUrl("https://www.omrbranch.com/");
		maximizeWindow();
		implicitWait();
	}

	@Test
	private void login() {
		// TODO Auto-generated method stub
	
	LoginePage page=new LoginePage();
}
}