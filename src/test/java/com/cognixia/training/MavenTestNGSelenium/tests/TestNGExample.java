package com.cognixia.training.MavenTestNGSelenium.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGExample {
	
	@Test
	public void testFirst() {
		System.out.println("Inside test First");
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
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Inside Before Method");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Inside Before Suite");
	}

}
