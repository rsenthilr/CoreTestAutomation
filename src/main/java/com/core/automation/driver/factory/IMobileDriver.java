package com.core.automation.driver.factory;

import org.openqa.selenium.WebDriver;

import com.core.automation.driver.entity.DriverDataForMobile;

public interface IMobileDriver {
	
	WebDriver getDriver(DriverDataForMobile driverDataMobile);

}
