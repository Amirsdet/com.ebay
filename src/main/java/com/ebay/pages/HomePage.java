package com.ebay.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ebay.utils.ElementUtil;

public class HomePage {

	WebDriver driver;
	ElementUtil elementUtil;

	By shopByCategory = By.id("gh-shop-a");

	By selectElectronic = By.xpath("//*[@id=\"gh-sbc\"]/tbody/tr/td[2]/h3[1]/a");
	By payload = By.xpath("//input[@id='gh-ac']");
	By iphonesBy = By.xpath("//*[@id=\"srp-river-results\"]/ul");
	By searchItem = By.xpath("//*[@id=\"gh-ac\"]");
	By selectCategory = By.id("gh-cat-td");
	By selectCategories = By.xpath("//*[@id=\"gh-cat\"]");
	By searchBtn = By.id("gh-btn");
	By textItem = By.xpath("//*[@id=\"srp-river-results\"]/ul/li[1]/div/div[2]/a/h3");

	// Constructor

	public HomePage(WebDriver driver) {

		elementUtil = new ElementUtil(driver);
		this.driver = driver;

	}
	// Operations

	public String verifyTitle() throws InterruptedException {
		Thread.sleep(2000);
		return elementUtil.doGetPageTitle();
	}

	public String electronicSelection() throws InterruptedException {
		elementUtil.doClick(shopByCategory);
		Thread.sleep(2000);
		elementUtil.waitForElementVisible(selectElectronic);
		return elementUtil.getElement(selectElectronic).getText();

	}

	public String searchItem(String searchitem) {

		elementUtil.getElement(searchItem).sendKeys(searchitem);
		elementUtil.getElement(searchBtn).click();
//		elementUtil.getElement(searchItem).getText();
		elementUtil.getElement(searchItem).clear();

		return searchitem;

	}

	public String selectCategory(String categoryName) throws InterruptedException {

		List<WebElement> elements = driver.findElements(selectCategories);

		if (elements == null) {
			System.out.println("element not visible");
		}

		for (WebElement e : elements) {

			Select s = new Select(e);
			Thread.sleep(200);
			s.selectByVisibleText(categoryName);

		}
		return categoryName;

	}

	public String getItemText() {
		return elementUtil.doGetText(textItem);
	}

	public void selectSearchCategories(String categoryName, String itemName) throws InterruptedException {
//		Thread.sleep(3000);
		categoryName = selectCategory(categoryName);
		itemName = searchItem(itemName);

	}

}
