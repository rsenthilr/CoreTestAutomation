package com.core.automation.driver.manager.mobile.local;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.core.automation.config.factory.ConfigFactory;

import io.appium.java_client.android.AndroidDriver;

public class AndroidManager {

	private AndroidManager() {
	}

	public static WebDriver getDriver() {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		// -- Common capability
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("automationName", "UiAutomator2");
		
		// -- App installation capability
		capabilities.setCapability("app", System.getProperty("user.dir")
				+ "/src/test/resources/Android_APKFiles/android-app.apk");
		
		// -- Mobile Browser Capability
		//capabilities.setCapability("browserName", "chrome");
		// capabilities.setCapability("chromedriverExecutableDir",
		// System.getProperty("user.dir")+"/CoreAutomation/src/test/resources/MobileDrivers/");
		// capabilities.setCapability("chromedriverChromeMappingFile",
		// System.getProperty("user.dir")+"/CoreAutomation/src/test/resources/MobileDrivers/mapping.json");
		// capabilities.setCapability("chromedriver_autodownload",
		// "--allow-insecure");
		return new AndroidDriver(
				ConfigFactory.getConfig().LocalAppiumServerURL(), capabilities);
	}

}
