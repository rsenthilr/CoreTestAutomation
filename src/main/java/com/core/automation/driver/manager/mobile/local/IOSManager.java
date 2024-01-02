package com.core.automation.driver.manager.mobile.local;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.core.automation.config.factory.ConfigFactory;

import io.appium.java_client.ios.IOSDriver;

public final class IOSManager {

	private IOSManager() {
	}

	public static WebDriver getDriver() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "ios");
		capabilities.setCapability("platformVersion", "16");
		capabilities.setCapability("deviceName", "iPhone 14");
		capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability("app", System.getProperty("user.dir" + "/ios-app.zip"));

		return new IOSDriver(ConfigFactory.getConfig().LocalAppiumServerURL(), capabilities);
	}

}
