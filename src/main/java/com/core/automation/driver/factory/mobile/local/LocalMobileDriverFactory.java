package com.core.automation.driver.factory.mobile.local;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;

import com.core.automation.config.enums.MobilePlatformType;
import com.core.automation.driver.manager.mobile.local.AndroidManager;
import com.core.automation.driver.manager.mobile.local.IOSManager;

public final class LocalMobileDriverFactory {
	

	private LocalMobileDriverFactory() {
	}
	
	private static final Map<MobilePlatformType, Supplier<WebDriver>> MAP = new EnumMap<>(MobilePlatformType.class);
	
	static {
		MAP.put(MobilePlatformType.ANDROID, AndroidManager::getDriver);
		MAP.put(MobilePlatformType.IOS, IOSManager::getDriver);
	}
	
	public static WebDriver getDriver(MobilePlatformType mobilePlatformType) {
		return MAP.get(mobilePlatformType).get();
	}

}
