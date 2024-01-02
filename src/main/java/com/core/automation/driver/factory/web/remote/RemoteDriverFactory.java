package com.core.automation.driver.factory.web.remote;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;

import com.core.automation.config.enums.BrowserType;
import com.core.automation.config.enums.RemoteModeType;

public final class RemoteDriverFactory {

	private RemoteDriverFactory() {
	}
	
	public static final Map<RemoteModeType, Function<BrowserType, WebDriver>> MAP = new EnumMap<>(RemoteModeType.class);

	static {
		MAP.put(RemoteModeType.SELENIUMGRID, SeleniumGridFactory::getDriver);
		MAP.put(RemoteModeType.SELENOID, SelenoidFactory::getDriver);
		MAP.put(RemoteModeType.BROWSERSTACK, BrowserStackFactory::getDriver);
	}
	public static WebDriver getDriver(RemoteModeType remoteMode,
			BrowserType browserType) {
		
		return MAP.get(remoteMode).apply(browserType);
	}
}
