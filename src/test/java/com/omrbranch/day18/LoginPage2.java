package com.omrbranch.day18;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.junit.Assert;
import org.openqa.selenium.By;
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


	public void faviconicon() throws InterruptedException {

		WebElement faviconElement = driver.findElement(By.cssSelector("link[rel='icon']"));

		// Extract the URL of the favicon
		String faviconUrl = faviconElement.getAttribute("href");

		// Download the favicon image
		BufferedImage faviconImage = null;
		try {
			faviconImage = ImageIO.read(new URL(faviconUrl));
			System.out.println(faviconUrl);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Load expected favicon image
		BufferedImage expectedImage = null;
		try {

			InputStream imageStream = getClass().getClassLoader().getResourceAsStream("Testdata/Favi_lmx.png");
			expectedImage = ImageIO.read(imageStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Compare favicon image with expected image
		if (compareImages(faviconImage, expectedImage)) {
			System.out.println("Favicon is correct!");
		} else {
			System.out.println("Favicon is incorrect!");
		}

	}

	// Method to compare two images
	private static boolean compareImages(BufferedImage img1, BufferedImage img2) {
		if (img1 == null || img2 == null) {
			return false;
		}

		if (img1.getWidth() != img2.getWidth() || img1.getHeight() != img2.getHeight()) {
			return false;
		}

		for (int y = 0; y < img1.getHeight(); y++) {
			for (int x = 0; x < img1.getWidth(); x++) {
				if (img1.getRGB(x, y) != img2.getRGB(x, y)) {
					return false;
				}
			}
		}
		return true;
	}

	private Object excelData(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	public void forgetpasswordinvalid() throws InterruptedException {
		Thread.sleep(2000);
		elementClick(getClkforgetpass());
		implicitWait(2);
		driver.findElement(By.id("email")).sendKeys("dnednejdn@gmail.com");
		elementClick(getClkresetbutt());
		implicitWait(5);
		WebElement g = driver
				.findElement(By.xpath("//div[contains(text(),' Could not send password reset link to email! ')]"));
		String actualText = g.getText();
		String expectedText = "Could not send password reset link to email!";

		try {
			Assert.assertEquals(expectedText, actualText);
			// assertTextEquals1(expectedText, actualText);

		} catch (AssertionError e) {
			System.out.println("Assertion failed: " + e.getMessage());

			// EmailNotificationManager.addMessage("The \"Forget password\" text is not
			// visible in Japanese.",false);
		}
		driver.findElement(By.id("email")).clear();
	}

	public void forgetpassvalid() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("rajan@movingwalls.com");
		elementClick(getClkresetbutt());
		implicitWait(10);

		WebElement g = driver.findElement(By.xpath(
				"//div[contains(text(),'Check your email for a link to reset your password. If it doesn’t appear within a few minutes, check your spam folder.')]"));
		String actualText = g.getText();
		String expectedText = "Check your email for a link to reset your password. If it doesn’t appear within a few minutes, check your spam folder.";

		try {
			Assert.assertEquals(expectedText, actualText);
			// assertTextEquals1(expectedText, actualText);

		} catch (AssertionError e) {
			System.out.println("Assertion failed: " + e.getMessage());

			// EmailNotificationManager.addMessage("The \"Forget password\" text is not
			// visible in Japanese.",false);
		}
	}
 
	
//	public void Login(String user, String pass) throws InterruptedException, AWTException, IOException {
//
//		
//		implicitWait(50);
//		sendKeys(getSnduser(), excelData(2, 1));
//		sendKeys(getSndpass(), excelData(3, 1));
//		Thread.sleep(2000);
//		elementClick(getClklog());
//		
//	}

	public void successmsg() throws InterruptedException, IOException {
		 
		String filepath = "Results.property";
		 
		Thread.sleep(1000);
		
		long start = System.currentTimeMillis();
		//elementClick(getClklog());
		implicitWait(10);
		driver.findElement(By.xpath("//a[@class='lmx-sec']")).isDisplayed();
		long finish = System.currentTimeMillis();
		long totalTime = (finish - start);
		System.out.println("Total Time for page load - " + totalTime + " milliseconds");
		 
		WebElement g = driver.findElement(By.xpath("//div[contains(text(),' Logged in successfully. ')]"));
		String actualText = g.getText();
		String expectedText = "Logged in successfully.";
		 
		Properties props = new Properties();
	
		org.testng.Assert.assertEquals(expectedText, actualText);
		
		
		
		
	}
		
}
