package com.jbk.login.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void correctCredentials() {
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("kiran@gmail.com");
		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys("123456");
		WebElement button = driver.findElement(By.xpath("//button"));
		button.click();

	}

}
