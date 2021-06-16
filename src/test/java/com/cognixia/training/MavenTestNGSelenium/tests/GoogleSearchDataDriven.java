package com.cognixia.training.MavenTestNGSelenium.tests;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cognixia.training.MavenTestNGSelenium.common.ReadFromExcel;

public class GoogleSearchDataDriven extends TestNGBase{
	
	private List<WebElement> suggestionslist;
	
	//1. Searching Google
	@Test (dataProvider = "getDataFromExcel")
	public void testGoogleSearch(String searchstring, String expected) throws InterruptedException {
		searchbox.sendKeys(searchstring);
		searchbox.submit();
		waitForTitleToContain(searchstring);
		Assert.assertEquals(driver.getTitle(), expected);
	}
	
	@DataProvider
	public Object[][] getDataFromExcel() throws IOException {
		return ReadFromExcel.readExcelData("resources/googlesearchtestdata.xlsx");
	}
}
