package com.core.automation.driver.impl.mobile;

import org.openqa.selenium.WebDriver;

import com.core.automation.driver.entity.DriverDataForMobile;
import com.core.automation.driver.factory.IMobileDriver;
import com.core.automation.driver.factory.mobile.remote.RemoteMobileDriverFactory;

public class RemoteMobileDriverImpl implements IMobileDriver {

	@Override
	public WebDriver getDriver(DriverDataForMobile driverDataMobile) {
		return RemoteMobileDriverFactory.getDriver(driverDataMobile.getMobileRemoteModeType(), driverDataMobile.getMobilePlatformType());
	}

}
