package com.core.automation.driver.factory;

import org.openqa.selenium.WebDriver;

import com.core.automation.driver.entity.DriverDataForWeb;

public interface IWebDriver {
	
	WebDriver getDriver(DriverDataForWeb driverDataWeb);

}
