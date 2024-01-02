package com.core.automation.driver.manager.web.remote.browserstack;

import java.util.HashMap;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.core.automation.config.factory.BrowserStackConfigFactory;

public final class BrowserStackChromeManager {

	private BrowserStackChromeManager() {
	}

	public static WebDriver getDriver() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito"); // ChromeOptions for starting chrome
											// in incognito mode

		MutableCapabilities capabilities = new MutableCapabilities();
		capabilities.setCapability("browserName", "Chrome");
		
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("os", "Windows");
		browserstackOptions.put("osVersion", "10");
		browserstackOptions.put("browserVersion", "latest");
		browserstackOptions.put("local", "false");
		browserstackOptions.put("seleniumVersion", "4.8.0");
		
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		capabilities.setCapability("bstack:options", browserstackOptions);

		return new RemoteWebDriver(
				BrowserStackConfigFactory.getConfig().browserStackURL(),
				capabilities);
	}

}
