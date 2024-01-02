package com.core.automation.driver.manager.web.remote.selenoid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.core.automation.config.factory.ConfigFactory;

public final class SelenoidChromeManager {
	
	private SelenoidChromeManager() {
	}

	public static WebDriver getDriver() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--ignore-certificate-errors-spki-list");
		chromeOptions.addArguments("--disable-popup-blocking");
		chromeOptions.setCapability("browserName",Browser.CHROME );

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

		return new RemoteWebDriver(ConfigFactory.getConfig().selenoidURL(), capabilities);
	}

}