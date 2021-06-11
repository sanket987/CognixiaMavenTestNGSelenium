package com.cognixia.training.MavenTestNGSelenium.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	protected static WebDriver driver;
	
	static void setProperties() {
		System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Selenium\\chromedriver.exe"); //Windows OS
		//The following path is valid for MAC and Linux OS
		System.setProperty("webdriver.chrome.driver", "/Users/ameya/Tools/Selenium/ChromeDriver91/chromedriver");
		System.setProperty("webdriver.gecko.driver", "/Users/ameya/Tools/Selenium/geckodriver");
	}
	
	protected static void openBrowser(String browser) {
		
		setProperties();
		
		if(browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if(browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

}
