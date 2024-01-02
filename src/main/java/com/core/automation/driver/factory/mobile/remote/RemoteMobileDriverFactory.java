package com.core.automation.driver.factory.mobile.remote;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;

import com.core.automation.config.enums.MobilePlatformType;
import com.core.automation.config.enums.MobileRemoteModeType;

public final class RemoteMobileDriverFactory {

	private RemoteMobileDriverFactory() {
	}
	
	public static final Map<MobileRemoteModeType, Function<MobilePlatformType, WebDriver>> MAP = new EnumMap<>(MobileRemoteModeType.class);

	static {
		MAP.put(MobileRemoteModeType.BROWSERSTACK, BrowserStackMobileFactory::getDriver);
		MAP.put(MobileRemoteModeType.SAUCELABS, SauceLabsMobileFactory::getDriver);
	}
	public static WebDriver getDriver(MobileRemoteModeType mobileRemoteMode,
			MobilePlatformType mobilePlatform) {
		
		return MAP.get(mobileRemoteMode).apply(mobilePlatform);
	}
}
