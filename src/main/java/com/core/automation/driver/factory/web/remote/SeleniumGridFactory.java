package com.core.automation.driver.factory.web.remote;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;

import com.core.automation.config.enums.BrowserType;
import com.core.automation.driver.manager.web.remote.seleniumgrid.SeleniumGridChromeManager;
import com.core.automation.driver.manager.web.remote.seleniumgrid.SeleniumGridFirefoxManager;

public final class SeleniumGridFactory {
	private SeleniumGridFactory() {
	}
	
	private static final Map<BrowserType, Supplier<WebDriver>> MAP = new EnumMap<>(BrowserType.class);
	
	static {
		MAP.put(BrowserType.CHROME,  SeleniumGridChromeManager::getDriver);
		MAP.put(BrowserType.FIREFOX, SeleniumGridFirefoxManager::getDriver);
	}
	
	public static WebDriver getDriver(BrowserType browserType) {
		return MAP.get(browserType).get();
	}

}
