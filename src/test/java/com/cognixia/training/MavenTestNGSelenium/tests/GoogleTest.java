package com.cognixia.training.MavenTestNGSelenium.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class GoogleTest {
	
	private WebElement searchbox;
	private WebDriver driver;
	
	@BeforeTest //Only runs Once before ALL the tests
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Tools\\Selenium\\chromedriver.exe"); //Windows OS
		//The following path is valid for MAC and Linux OS
		System.setProperty("webdriver.chrome.driver", "/Users/ameya/Tools/Selenium/ChromeDriver91/chromedriver");
		System.setProperty("webdriver.gecko.driver", "/Users/ameya/Tools/Selenium/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		searchbox = driver.findElement(By.name("q"));
	}

	//1. Searching Google
	@Test
	public void testGoogleSearch() throws InterruptedException {
		//Enter string in searchbox
		
		String searchstring = "Selenium";
		searchbox.sendKeys(searchstring);
		
		//Submit the search
		searchbox.submit();
		
		WebDriverWait myWait = new WebDriverWait(driver,5);
		myWait.until(ExpectedConditions.titleContains(searchstring));
		
		//Verify that the title of new page contains the searchstring
		String expected = searchstring + " - Google Search";
		String actual = driver.getTitle();
		
		//Assert.assertTrue(actual.contains(expected), "Titles do not match. Actual title is: "+actual+ " expected is :"+expected);
		//Assert.assertTrue(actual.contains(expected));
		Assert.assertEquals(actual, expected);
	}
	
	//2. Suggestions List
	@Test @Ignore
	public void testSuggestions() {
		
	}
	
	//3. Results Page
	@Test @Ignore
	public void testResultsPage() {
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

}
