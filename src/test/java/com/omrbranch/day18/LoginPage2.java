package com.omrbranch.day18;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

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

}
