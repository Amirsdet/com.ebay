package com.ebay.pages;

import com.ebay.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	ElementUtil elementUtil;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	By signIn = By.xpath("//*[@id=\"gh-ug\"]/a");

	public void doLoginPage() {
		driver.findElement(signIn).click();

	}
}
