package com.core.automation.driver.manager.mobile.remote;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.core.automation.config.factory.BrowserStackConfigFactory;

public final class BrowserStackAndroidManager {
	
	private BrowserStackAndroidManager() {
	}
	
	public static WebDriver getDriver() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		HashMap<String, Object> browserstackOptions = new HashMap<>();
		browserstackOptions.put("projectName", "FirstProject");
		browserstackOptions.put("buildName", "browser-stack-build-1");
		browserstackOptions.put("sessionName", "FirstTest");
		browserstackOptions.put("appiumVersion", "1.22.0");

		capabilities.setCapability("bstack:options", browserstackOptions);
		capabilities.setCapability("platformName", "android");
		capabilities.setCapability("appium:platformVersion", "9.0");
		capabilities.setCapability("appium:deviceName", "Google Pixel 3");
		capabilities.setCapability("appium:app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
		capabilities.setCapability("appium:automationName", "uiautomator2");

		return new RemoteWebDriver(BrowserStackConfigFactory.getConfig().browserStackURL(), capabilities);

	}

}
