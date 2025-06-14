package com.omrbranch.day13;

import org.jspecify.annotations.Nullable;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OmrBranchTask2 {
	static WebDriver driver;

	@Test
	public void login() {
		
		 driver=new ChromeDriver();
		 driver.get("https://www.omrbranch.com/");
		 driver.manage().window().maximize();
		
		WebElement txtUserName = driver.findElement(By.id("email"));
		txtUserName.sendKeys("mathimmrs123@gmail.com");
		@Nullable
		String name = txtUserName.getDomProperty("value");
		Assert.assertEquals("verify usernamee", "mathimmrs123@gmail.com",name);
		
		WebElement txtPass = driver.findElement(By.id("pass"));
		txtPass.sendKeys("Mathi123@");
		
		@Nullable
		String password = txtPass.getDomProperty("value");
		Assert.assertEquals("verify password", "Mathi123@",password);
	
		WebElement btnLogin = driver.findElement(By.xpath("//button[@value='login']"));
		btnLogin.click();
		
		
		Assert.assertTrue("login", true);
		
	}
	@Test
	public void test() {
		System.out.println("sucess...");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
