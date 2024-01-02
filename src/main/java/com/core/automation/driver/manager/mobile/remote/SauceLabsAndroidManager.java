package com.core.automation.driver.manager.mobile.remote;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.core.automation.config.factory.SauceLabsConfigFactory;

public final class SauceLabsAndroidManager {

	private SauceLabsAndroidManager() {}

	public static WebDriver getDriver() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		HashMap<String, Object> browserstackOptions = new HashMap<>();
		browserstackOptions.put("projectName", "FirstProject");
		browserstackOptions.put("buildName", "browser-stack-build-1");
		browserstackOptions.put("sessionName", "FirstTest");

		capabilities.setCapability("bstack:options", browserstackOptions);
		capabilities.setCapability("platformName", "android");
		capabilities.setCapability("platformVersion", "9.0");
		capabilities.setCapability("deviceName", "Google Pixel 3");
		capabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

		return new RemoteWebDriver(SauceLabsConfigFactory.getConfig().sauceLabsURL(), capabilities);

	}
}
