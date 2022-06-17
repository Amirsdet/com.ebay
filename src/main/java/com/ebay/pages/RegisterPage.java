package com.ebay.pages;

import com.ebay.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
	WebDriver driver;
	ElementUtil elementUtil;

	By registerLink = By.xpath("//*[@id=\"gh-ug-flex\"]/a");
	By fname = By.id("firstname");
	By lname = By.id("lastname");
	By email = By.id("Email");
	By pass = By.id("password");
	By cAccount = By.id("EMAIL_REG_FORM_SUBMIT");

	public void doRegister(WebDriver driver) {

		driver.findElement(registerLink).click();
		driver.findElement(fname).sendKeys("Amir");
		driver.findElement(lname).sendKeys("Madaoui");
		driver.findElement(email).sendKeys("amirsdet06@gmail.com");
		driver.findElement(pass).sendKeys("admin123456789");
		driver.findElement(cAccount).click();

	}

}
