package com.core.automation.testbase;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.core.automation.driver.Driver;

public class MobileTestBase {

	@BeforeMethod
	public void setUp() {

		Driver.initDriverMobile();

	}
	
	@AfterMethod
	public void tearDown() {
		Driver.quitDriver();
	}

}
