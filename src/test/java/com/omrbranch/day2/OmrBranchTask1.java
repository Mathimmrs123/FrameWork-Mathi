package com.omrbranch.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OmrBranchTask1 {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.omrbranch.com/");
		
		WebElement txtUsername = driver.findElement(By.id("email"));
		txtUsername.sendKeys("mathimmrs123@gamil.com");
		String text = txtUsername.getDomProperty("value");
	    System.out.println("Username="+text);
		
		WebElement txtPass = driver.findElement(By.id("pass"));
		txtPass.sendKeys("mathi123@");
		String text2 = txtPass.getDomProperty("value");
		System.out.println("Password="+text2);
		
		WebElement btnLogine = driver.findElement(By.xpath("//button[text()='Login']"));
		btnLogine.click();
		
		Thread.sleep(2000);
		
		driver.quit();
		
		
		
}

}
