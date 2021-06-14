package com.cognixia.training.MavenTestNGSelenium.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGExample {
	
	private String name;
	
	@Test
	public void testFirst() {
		System.out.println("Inside test First");
		getData(); //Calling the method or executing the method
		name = "Ameya";
		
	}
	
	public void getData() { //Declaring the method
		System.out.println("Inside Get Data");
	}
	
	@BeforeTest
	public void setUp() {
		System.out.println("Inside Setup");
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("Inside Tear Down");
	}
	
	@Test
	public void testSecond() {
		System.out.println("Inside test Second");
		System.out.println("Name is: "+name);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Inside Before Method");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Inside Before Suite");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("Inside After Suite");
	}
	
	@Test
	public void testA() {
		System.out.println("Inside test A");
		System.out.println("Name is: "+name);
	}
}
