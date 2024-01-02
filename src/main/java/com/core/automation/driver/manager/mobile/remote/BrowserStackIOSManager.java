package com.core.automation.driver.manager.mobile.remote;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.core.automation.config.factory.BrowserStackConfigFactory;

public final class BrowserStackIOSManager {
	private BrowserStackIOSManager() {
	}

	public static WebDriver getDriver() {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		HashMap<String, Object> browserstackOptions = new HashMap<>();
		browserstackOptions.put("projectName", "FirstProject");
		browserstackOptions.put("buildName", "browser-stack-build-1");
		browserstackOptions.put("sessionName", "FirstTest");

		capabilities.setCapability("bstack:options", browserstackOptions);
		capabilities.setCapability("platformName", "ios");
		capabilities.setCapability("platformVersion", "16");
		capabilities.setCapability("deviceName", "iPhone 14");
		capabilities.setCapability("app",
				"bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");

		return new RemoteWebDriver(
				BrowserStackConfigFactory.getConfig().browserStackURL(),
				capabilities);

	}
}
