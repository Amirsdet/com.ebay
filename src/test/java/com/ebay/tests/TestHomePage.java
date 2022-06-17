package com.ebay.tests;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ebay.base.BasePage;
import com.ebay.pages.HomePage;
import com.ebay.utils.ExcelUtil;

@Test
public class TestHomePage {
	WebDriver driver;
	Properties pros;
	BasePage basePage;
	HomePage homePage;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		basePage = new BasePage();
		pros = basePage.init_Properties();
		driver = basePage.init_Driver(pros);
		homePage = new HomePage(driver);

	}

	@Test(priority = 1)
	public void verifyTitle() throws InterruptedException {

		String actualTitle = homePage.verifyTitle();
		String expectedTitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(priority = 2, enabled = true)
	public void electronicSelectionTest() throws InterruptedException {

		String actualElectronics = homePage.electronicSelection();
		Thread.sleep(2000);
		String expectedElectronics = "Electronics";
		Assert.assertEquals(actualElectronics, expectedElectronics);

	}

	@Test(priority = 3, enabled = false)
	public void doSearchItemTest() throws InterruptedException {
		homePage.searchItem("steve Jobs");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));// give a time to get the response
		Assert.assertEquals(homePage.getItemText(), "Steve Jobs - Hardcover By Isaacson, Walter - GOOD");

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = ExcelUtil.getTestData("Categories");
		return data;

	}

	@Test(priority = 4, dataProvider = "getData")
	public void doSelectSearchCategories(String categoryName, String itemName) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		homePage.selectSearchCategories(categoryName, itemName);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
