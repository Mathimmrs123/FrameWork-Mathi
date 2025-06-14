package com.omrbranch.day13;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.jspecify.annotations.Nullable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class OmrBranchTask1 {
	
	static WebDriver driver;
	@BeforeClass
	public static void beforeClass() {
		
		 driver=new ChromeDriver();
		 driver.get("https://www.omrbranch.com/");
		 driver.manage().window().maximize();
		
	}
	@AfterClass
	public static void afterClass() {

	driver.quit();
	}
	@Before
	public void beforeMethod() throws IOException {
TakesScreenshot screenshot=(TakesScreenshot)driver;
File file = screenshot.getScreenshotAs(OutputType.FILE);
File desFile = new File("C:\\Users\\mathi\\OneDrive\\Desktop\\beforeClass.png");
FileUtils.copyFile(file, desFile);
	}
	@After
	public void afterMethod() throws IOException {
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File file = screenshot.getScreenshotAs(OutputType.FILE);
		File desFile = new File("C:\\Users\\mathi\\OneDrive\\Desktop\\afterClass.png");
		FileUtils.copyFile(file, desFile);

	}
	@Test
	public void login() {
		
		WebElement txtUserName = driver.findElement(By.id("email"));
		
		@Nullable
		String name = txtUserName.getDomProperty("value");
		Assert.assertEquals("verify usernamee", "mathimmrs123@gmail.com",name);
		
		txtUserName.sendKeys("mathimmrs123@gmail.com");
		
		WebElement txtPass = driver.findElement(By.id("pass"));
		txtPass.sendKeys("Mathi123@");
		
		WebElement btnLogin = driver.findElement(By.xpath("//button[@value='login']"));
		btnLogin.click();
		
		
	
	}

}
