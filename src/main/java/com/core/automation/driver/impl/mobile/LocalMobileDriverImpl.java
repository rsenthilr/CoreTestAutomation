package com.core.automation.driver.impl.mobile;

import org.openqa.selenium.WebDriver;

import com.core.automation.driver.entity.DriverDataForMobile;
import com.core.automation.driver.factory.IMobileDriver;
import com.core.automation.driver.factory.mobile.local.LocalMobileDriverFactory;

public class LocalMobileDriverImpl implements IMobileDriver {

	@Override
	public WebDriver getDriver(DriverDataForMobile driverDataMobile) {
		return LocalMobileDriverFactory.getDriver(driverDataMobile.getMobilePlatformType());
	}

}
