package com.omrbranch.day9;
import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OmrGroceryTask1 {
public static void main(String[] args) throws InterruptedException {
		
	WebDriver driver = new ChromeDriver();
	driver.get("https://omrbranch.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

	WebElement txtEmail = driver.findElement(By.id("email"));
	txtEmail.sendKeys("mathimmrs123@gmail.com");

	WebElement txtPassword = driver.findElement(By.id("pass"));
	txtPassword.sendKeys("Mathi123@");

	WebElement btnLogin = driver.findElement(By.xpath("//button[text()='Login']"));
	btnLogin.click();

	WebElement textWelcome = driver.findElement(By.xpath("//a[contains(text(),'Welcome')]"));
	String welcome = textWelcome.getText();
	System.out.println(welcome);
	
	WebElement btnCart = driver.findElement(By.className("cart_btn"));
	btnCart.click();

	
	List<WebElement> elements = driver.findElements(By.xpath("//i[@class='fa fa-close']"));

	for (WebElement webElement : elements) {
		Thread.sleep(1000);
		webElement.click();

	}

	WebElement textClose = driver.findElement(By.xpath("//a[@class='cart_btn_remove']"));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click()", textClose);


	WebElement txtSearch = driver.findElement(By.id("search"));
	txtSearch.sendKeys("nuts", Keys.ENTER);
	
	List<WebElement> nutsName = driver.findElements(By.xpath("//h5[@data-testid='productname']"));
	for (WebElement webElement : nutsName) {
		String name = webElement.getText();
		System.out.println(name);
	}
	
	List<WebElement> nutsPrice = driver.findElements(By.xpath("//span[@class='newPrice font18 color20']"));
	for (WebElement webElement : nutsPrice) {
		String price = webElement.getText();
		System.out.println(price);
		
	}
			
	Thread.sleep(1000);
	WebElement btnAdd = driver.findElement(By.xpath("(//a[text()='Add'])[1]"));
	btnAdd.click();

	WebElement btnAdd1 = driver.findElement(By.id("cart-22"));
	btnAdd1.click();

	WebElement btnGotocart = driver.findElement(By.xpath("//a[text()=' Go To Cart ']"));
	js.executeScript("arguments[0].click()", btnGotocart);

	WebElement txtMycart = driver.findElement(By.xpath("//h5[text()='My Cart']"));
	String mycart = txtMycart.getText();
	System.out.println(mycart);

	WebElement txtAddress = driver.findElement(By.xpath("//div[@data-toggle='modal']"));
	txtAddress.click();

	Thread.sleep(2000);
	WebElement ddnAddrtype = driver.findElement(By.id("address_type"));
	Select selectaddr = new Select(ddnAddrtype);
	selectaddr.selectByVisibleText("Home");

	WebElement txtFisrtname = driver.findElement(By.name("first_name"));
	txtFisrtname.sendKeys("Mathiyazhagan");

	WebElement txtLastname = driver.findElement(By.name("last_name"));
	txtLastname.sendKeys("R");

	WebElement txtContact = driver.findElement(By.name("mobile"));
	txtContact.sendKeys("9092798486");

	WebElement txtHouseno = driver.findElement(By.name("apartment"));
	txtHouseno.sendKeys("Plot 177");

	WebElement txtAddr = driver.findElement(By.name("address"));
	txtAddr.sendKeys("4thMain road ");

	Thread.sleep(3000);
	WebElement ddnCountry = driver.findElement(By.name("country"));
	Select selectcountry = new Select(ddnCountry);
	selectcountry.selectByValue("101");

	WebElement ddnState = driver.findElement(By.name("state"));
	Select selectstate = new Select(ddnState);
	selectstate.selectByValue("35");

	WebElement ddnCity = driver.findElement(By.name("city"));
	Select selectcity = new Select(ddnCity);
	selectcity.selectByValue("3659");

	WebElement txtZip = driver.findElement(By.name("zipcode"));
	txtZip.sendKeys("600091");

	WebElement btnSave = driver.findElement(By.xpath("(//button[text()='Save'])[3]"));
	btnSave.click();

	Thread.sleep(2000);
	WebElement ddnPaymentType = driver.findElement(By.id("payment_type"));
	Select selectpaytype = new Select(ddnPaymentType);
	selectpaytype.selectByValue("debit_card");

	WebElement clkVisa = driver.findElement(By.xpath("//label[@for='visa_card']"));
	clkVisa.click();

	WebElement txtCardno = driver.findElement(By.name("card_no"));
	txtCardno.sendKeys("5555555555552222");

	WebElement ddnMonth = driver.findElement(By.name("month"));
	Select selectmonth = new Select(ddnMonth);
	selectmonth.selectByValue("April");

	WebElement ddnYear = driver.findElement(By.name("year"));
	Select selectyear = new Select(ddnYear);
	selectyear.selectByValue("2028");

	WebElement txtCvv = driver.findElement(By.name("cvv"));
	txtCvv.sendKeys("8562");

	WebElement btnPlaceorder = driver.findElement(By.id("placeOrder"));
	btnPlaceorder.click();

	WebElement textOrderid = driver.findElement(By.xpath("(//p[@class='font18 color20 fontSemiBold mb-0'])[1]"));
	String textorder = textOrderid.getText();
	System.out.println(textorder);

}

}

