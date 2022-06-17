package com.ebay.tests;

import com.ebay.base.BasePage;
import com.ebay.pages.LoginPage;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest {

  WebDriver driver;
  Properties pros;
  BasePage basePage;
  LoginPage loginPage;


  @BeforeMethod(alwaysRun = true)
  public void setUp() {
    basePage = new BasePage();
    pros = basePage.init_Properties();
    driver = basePage.init_Driver(pros);
    loginPage = new LoginPage(driver);

  }

  @Test(priority = 1)
  public void LoginPageTest() {
    loginPage.doLoginPage();// excel

  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }

}
