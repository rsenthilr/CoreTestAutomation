package com.core.automation.driver.factory.web.remote;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;

import com.core.automation.config.enums.BrowserType;
import com.core.automation.driver.manager.web.remote.browserstack.BrowserStackChromeManager;
import com.core.automation.driver.manager.web.remote.browserstack.BrowserStackFirefoxManager;

public final class BrowserStackFactory {

	private BrowserStackFactory() {
	}

	private static final Map<BrowserType, Supplier<WebDriver>> MAP = new EnumMap<>(BrowserType.class);

	static {
		MAP.put(BrowserType.CHROME, BrowserStackChromeManager::getDriver);
		MAP.put(BrowserType.FIREFOX, BrowserStackFirefoxManager::getDriver);
	}

	public static WebDriver getDriver(BrowserType browserType) {
		return MAP.get(browserType).get();
	}
}
