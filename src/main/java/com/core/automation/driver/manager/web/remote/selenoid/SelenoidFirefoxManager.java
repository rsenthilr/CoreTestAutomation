package com.core.automation.driver.manager.web.remote.selenoid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.core.automation.config.factory.ConfigFactory;

public final class SelenoidFirefoxManager {
	
	private SelenoidFirefoxManager() {
	}

	public static WebDriver getDriver() {
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		FirefoxProfile profile = new FirefoxProfile();

		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(false);
		profile.setPreference("network.proxy.type", 0);

		firefoxOptions.setProfile(profile);
		firefoxOptions.setCapability("browserName", Browser.FIREFOX);

		return new RemoteWebDriver(ConfigFactory.getConfig().selenoidURL(), firefoxOptions);
	}

}
