package com.core.automation.driver.manager.web.remote.seleniumgrid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.core.automation.config.enums.BrowserType;
import com.core.automation.config.factory.ConfigFactory;

public final class SeleniumGridFirefoxManager {
	
	private SeleniumGridFirefoxManager() {
	}
	
	public static WebDriver getDriver() {

		FirefoxOptions ffOptions = new FirefoxOptions();
		FirefoxProfile profile = new FirefoxProfile();

		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(false);
		profile.setPreference("network.proxy.type", 0);

		ffOptions.setProfile(profile);
		ffOptions.setCapability("browserName", BrowserType.FIREFOX);

		return new RemoteWebDriver(ConfigFactory.getConfig().seleniumGridURL(), ffOptions);

	}
}
