package com.core.automation.driver.factory.mobile.remote;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;

import com.core.automation.config.enums.MobilePlatformType;
import com.core.automation.driver.manager.mobile.remote.BrowserStackAndroidManager;
import com.core.automation.driver.manager.mobile.remote.BrowserStackIOSManager;

public final class SauceLabsMobileFactory {

	private SauceLabsMobileFactory() {
	}

	private static final Map<MobilePlatformType, Supplier<WebDriver>> MAP = new EnumMap<>(MobilePlatformType.class);

	static {
		MAP.put(MobilePlatformType.ANDROID, BrowserStackAndroidManager::getDriver);
		MAP.put(MobilePlatformType.IOS, BrowserStackIOSManager::getDriver);
	}

	public static WebDriver getDriver(MobilePlatformType platformType) {
		return MAP.get(platformType).get();
	}
}
