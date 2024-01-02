package com.core.automation.testbase;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.core.automation.driver.Driver;

public class WebTestBase {

	@BeforeMethod
	public void setUp() {

		Driver.initDriverWeb();

	}
	
	@AfterMethod
	public void tearDown() {
		Driver.quitDriver();
	}

}
