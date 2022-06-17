package com.ebay.tests;

import com.ebay.base.BasePage;
import com.ebay.pages.RegisterPage;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterPageTest {

  WebDriver driver;
  Properties pros;
  BasePage basePage;

  RegisterPage registerPage;

  @BeforeMethod(alwaysRun = true)
  public void setUp() {
    basePage = new BasePage();
    pros = basePage.init_Properties();
    driver = basePage.init_Driver(pros);
//		homePage = new HomePage(driver);
    registerPage = new RegisterPage();

  }

  @Test(enabled = true)
  public void registerUser() {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

    registerPage.doRegister(driver);

  }

  @AfterMethod()
  public void tearDown() {
    driver.quit();
  }

}
