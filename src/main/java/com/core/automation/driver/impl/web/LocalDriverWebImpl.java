package com.core.automation.driver.impl.web;

import org.openqa.selenium.WebDriver;

import com.core.automation.driver.entity.DriverDataForWeb;
import com.core.automation.driver.factory.IWebDriver;
import com.core.automation.driver.factory.web.local.LocalDriverFactory;

public class LocalDriverWebImpl implements IWebDriver {

	@Override
	public WebDriver getDriver(DriverDataForWeb driverDataWeb) {
		return LocalDriverFactory.getDriver(driverDataWeb.getBrowserType());
	}

}
