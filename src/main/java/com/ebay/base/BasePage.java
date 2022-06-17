package com.ebay.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {
	WebDriver driver;
	Properties pros;

	public WebDriver init_Driver(Properties pros) {
		String browser = pros.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("browser name not found !");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get(pros.getProperty("url"));
//		driver.manage().deleteAllCookies();
		return driver;
	}

	public Properties init_Properties() {
		pros = new Properties();
		String configPath = "/Users/amirouchemadaoui/git/TechbeeMaybatch/com.ebay/src/main/java/com/ebay/config/config.properties";
		try {
			FileInputStream file = new FileInputStream(configPath);
			pros.load(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pros;
	}
}