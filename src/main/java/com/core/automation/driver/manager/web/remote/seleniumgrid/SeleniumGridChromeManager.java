package com.core.automation.driver.manager.web.remote.seleniumgrid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.core.automation.config.enums.BrowserType;
import com.core.automation.config.factory.ConfigFactory;

public final class SeleniumGridChromeManager {
	private SeleniumGridChromeManager() {
	}
	
	public static WebDriver getDriver() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--ignore-certificate-errors-spki-list");
		chromeOptions.addArguments("--disable-popup-blocking");
		chromeOptions.setCapability("browserName",BrowserType.CHROME );

		return new RemoteWebDriver(ConfigFactory.getConfig().seleniumGridURL(), chromeOptions);
	}
}
