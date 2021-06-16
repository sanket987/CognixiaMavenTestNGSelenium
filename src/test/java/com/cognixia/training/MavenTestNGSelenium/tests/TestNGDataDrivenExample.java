package com.cognixia.training.MavenTestNGSelenium.tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cognixia.training.MavenTestNGSelenium.common.ReadFromExcel;

public class TestNGDataDrivenExample {
	
	
	@Test (dataProvider = "getDataFromExcel")
	public void myTest(String firstname, String lastname, String city) {
		System.out.print(firstname);
		System.out.print(" ");
		System.out.print(lastname);
		System.out.print(" ");
		System.out.println(city);
	}
	
	@DataProvider
	public Object[][] getDataFromExcel() throws IOException {
		return ReadFromExcel.readExcelData("resources/testdata.xlsx");
	}	
	
	@DataProvider					// A data provider in TestNG needs to return a 2 dimensional Object Array
	public Object[][] getData() {
									// Within this method we can hardcode data or read it from an external file if we want
		String [][] names = new String[5][3];
		
		//Row 1
		names[0][0] = "Ameya";
		names[0][1] = "Naik";
		names[0][2] = "Pune";
		
		//Row 2
		names[1][0] = "Rohit";
		names[1][1] = "Bhargava";
		names[1][2] = "Haridwar";
		
		//Row 3
		names[2][0] = "Nitin";
		names[2][1] = "Goel";
		names[2][2] = "Haridwar";
		
		//Row 4
		names[3][0] = "Ramakrishna";
		names[3][1] = "Uppala";
		names[3][2] = "Guntur";
		
		//Row 5
		names[4][0] = "Tanya";
		names[4][1] = "Vadhva";
		names[4][2] = "Haridwar";
		
		return names;
	}

}
