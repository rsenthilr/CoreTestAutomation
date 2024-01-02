package com.auto.tests.web;



import static org.testng.Assert.assertTrue;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.core.automation.pages.web.orangehrm.OrangeHRMLoginPage;
import com.core.automation.testbase.WebTestBase;

class DemoWebTest extends WebTestBase {

	/*
	 * Web Test - capable of running in Local &
	 * Remote(SeleniumGrid/Selenoid/Browserstack) Browser: Chrome or Firefox
	 */

	@Test
	void demoTest() {
		
		new OrangeHRMLoginPage()
			.loginToApplication("Admin", "admin123").logoutOrangeHRMApplication("Logout");
		
		System.out.println("Test.....");
	}
	
	@Test
	void skipTest() {
		throw new SkipException("Skipped the Test");
	}
	
	@Test
	void failTest() {
		assertTrue(false);
	}

}
