package com.omrbranchday15;


import java.io.IOException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class ExcelBaseClassJunit extends BaseClass {
	
	@BeforeClass
	public static void beforeClass() {

		browserLaunch("CHROME");

		enterApplnUrl("https://www.omrbranch.com/");
		
		maximizeWindow();

		implicitWait();
	}
	
	@AfterClass
	public static void afterClass() {
    closeWindow();
	}
	
	@Test
	public void creatorderId() throws IOException, InterruptedException {

		WebElement txtEmail = findLocatorById("email");

		elementSendKeys(txtEmail, getCellData("Omr", 1, 0));

		WebElement txtPass = findLocatorById("pass");

		elementSendKeys(txtPass, getCellData("Omr", 1, 1));

		WebElement btnLogine = findLocatorByXpath("//button[@value='login']");

		elementClick(btnLogine);
		
		WebElement textWelcome=findLocatorByXpath("//a[@data-testid='username']");
	String elementGetText = elementGetText(textWelcome);
	Assert.assertEquals("verify after login","Welcome Mathi",elementGetText);
		
		
		WebElement btnCart = findLocatorByClassName("cart_btn");
		elementClick(btnCart);
		
		List<WebElement> cartaddedItems = findLocatorsByXpath("//i[@class='fa fa-close']");
		
		for (WebElement webElement : cartaddedItems) {
			Thread.sleep(1000);
			elementClick(webElement);	
		}
				
		WebElement textClose = findLocatorByXpath("//a[@class='cart_btn_remove']");
		elementClickJs(textClose);
		
		
		
		navigateRefresh("https://omrbranch.com/");
		
		WebElement txtSearch = findLocatorById("search");
		insert(txtSearch, getCellData("Omr", 1, 2));
		
		WebElement SearchBoxConfrimation = findLocatorByXpath("//h5[contains(text(),'Yogabars')]");
		String elementGetText2 = elementGetText(SearchBoxConfrimation);
		Thread.sleep(1000);
		
		WebElement btnAdd = findLocatorByXpath("(//a[text()='Add'])[1]");
		elementClick(btnAdd);
		
		WebElement btnAdd1 = findLocatorById("cart-22");
		elementClick(btnAdd1);

		WebElement btnGotocart = findLocatorByXpath("//a[text()=' Go To Cart ']");
		elementClickJs(btnGotocart);

		WebElement txtAddress = findLocatorByXpath("//div[@data-toggle='modal']");
		elementClick(txtAddress);
		
		
		Thread.sleep(2000);

		WebElement ddnAddrtype = findLocatorById("address_type");
		insert(ddnAddrtype, getCellData("Omr", 1, 3));

		WebElement txtFirstname = findLocatorByName("first_name");
		elementSendKeys(txtFirstname,getCellData("Omr", 1, 4));

		WebElement txtLastname = findLocatorByName("last_name");
		elementSendKeys(txtLastname, getCellData("Omr", 1, 5));

		WebElement txtContact = findLocatorByName("mobile");
		elementSendKeys(txtContact, getCellData("Omr", 1, 6));

		WebElement txtHouseno = findLocatorByName("apartment");
		elementSendKeys(txtHouseno, getCellData("Omr", 1, 7));

		WebElement txtAddr = findLocatorByName("address");
		elementSendKeys(txtAddr, getCellData("Omr", 1, 8));
		
		WebElement ddnState = findLocatorByName("state");
		insert(ddnState, getCellData("Omr", 1, 9));

		Thread.sleep(500);
		
		WebElement ddnCity = findLocatorByName("city");
		insert(ddnCity, getCellData("Omr", 1, 10));

		WebElement txtZip = findLocatorByName("zipcode");
		elementSendKeys(txtZip, getCellData("Omr", 1, 11));

		WebElement btnSave = findLocatorByXpath("(//button[text()='Save'])[3]");
		elementClick(btnSave);

		Thread.sleep(2000);

		WebElement ddnPaymentType = findLocatorById("payment_type");
		insert(ddnPaymentType, getCellData("Omr", 1, 12));

		WebElement clkVisa = findLocatorByXpath("//label[@for='visa_card']");
		elementClick(clkVisa);

		WebElement txtCardno = findLocatorByName("card_no");
		elementSendKeys(txtCardno, getCellData("Omr", 1, 13));
				
		WebElement ddnMonth = findLocatorByName("month");
		insert(ddnMonth, getCellData("Omr", 1, 14));
				
		WebElement ddnYear = findLocatorByName("year");
		insert(ddnYear, getCellData("Omr", 1, 15));
		
		WebElement txtCvv = findLocatorByName("cvv");
		elementSendKeys(txtCvv, getCellData("Omr", 1, 16));
			
		WebElement btnPlaceorder = findLocatorById("placeOrder");
		elementClick(btnPlaceorder);
				
//		WebElement textOrderid = findLocatorByXpath("(//p[@class='font18 color20 fontSemiBold mb-0'])[1]");
//		elementGetText(textOrderid);
		Thread.sleep(1000);
		WebElement txtEmail1 = findLocatorById("email");

		elementSendKeys(txtEmail1, getCellData("Omr", 1, 0));

		WebElement txtPass1 = findLocatorById("pass");

		elementSendKeys(txtPass1, getCellData("Omr", 1, 1));

		WebElement btnLogine1 = findLocatorByXpath("//button[@value='login']");

		elementClick(btnLogine1);
		
		//WebElement textWelcome = driver.findElement(By.xpath("//a[contains(text(),'Welcome')]"));
		
		WebElement text = findLocatorByXpath("//a[contains(text(),'Welcome')]");
		elementClick(text);
		
		WebElement text1 = findLocatorByXpath("//a[contains(text(),'My Account')]");
		elementClick(text1);
		
		
		
		WebElement text3 = findLocatorByXpath("//a[contains(text(),'orders')]");
		elementClick(text3);
		
		WebElement text4 = findLocatorByXpath("(//p[contains(text(),'Order No')])[1]");
		elementGetText(text4);
			
		createCellAndSetData("Omr", 1, 17, elementGetText(text4));
		
	}

	}

