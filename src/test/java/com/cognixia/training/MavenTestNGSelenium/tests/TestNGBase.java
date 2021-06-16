package com.cognixia.training.MavenTestNGSelenium.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestNGBase {
	
	protected WebDriver driver;
	protected WebElement searchbox;
	protected WebElement searchbutton;
	protected String browser;
	
	@BeforeTest
	protected void openBrowser() {
		browser = "Firefox";
		System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Selenium\\chromedriver.exe"); //Windows OS
		//The following path is valid for MAC and Linux OS
		System.setProperty("webdriver.chrome.driver", "/Users/ameya/Tools/Selenium/ChromeDriver91/chromedriver");
		System.setProperty("webdriver.gecko.driver", "/Users/ameya/Tools/Selenium/geckodriver");
		switch (browser) {
			case "Firefox":
				driver = new FirefoxDriver();
				break;
			case "Chrome":
				driver = new ChromeDriver();
				break;
			default:
				System.out.println("You requested for another browser which is not available. Hence running this script on Google Chrome");
				driver = new ChromeDriver();
				break;
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterTest
	protected void tearDown() {
		driver.quit();
	}

	@BeforeMethod
	protected void resetBrowser() {
		driver.navigate().to("https://www.google.com");
		searchbox = driver.findElement(By.name("q"));
		searchbutton = driver.findElement(By.name("btnK"));
	}
	
	protected void waitForSuggestionsToLoad(String searchstring) {
		WebDriverWait myWait = new WebDriverWait(driver, 5);
		myWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//li[@data-view-type='1']//div[@role='option']"), searchstring));
	}
	
	protected void waitForTextToBePresentInElement(By e, String text) {
		WebDriverWait myWait = new WebDriverWait(driver, 5);
		myWait.until(ExpectedConditions.textToBePresentInElementLocated(e, text));
		
	}
	
	protected void waitForTitleToContain(String searchstring) {
		WebDriverWait myWait = new WebDriverWait(driver, 5);
		myWait.until(ExpectedConditions.titleContains(searchstring));
	}

}
