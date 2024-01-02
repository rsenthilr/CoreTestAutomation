package com.core.automation.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

import com.core.automation.config.enums.MobilePlatformType;
import com.core.automation.config.factory.ConfigFactory;
import com.core.automation.driver.entity.DriverDataForMobile;
import com.core.automation.driver.entity.DriverDataForWeb;
import com.core.automation.driver.factory.DriverFactory;
import com.core.automation.driver.factory.DriverManager;

public class Driver {

	// local Web, remote Web, local mobile, remote mobile

	private Driver() {
	}

	public static void initDriverWeb() {

		if (Objects.isNull(DriverManager.getDriver())) {

			DriverDataForWeb driverDataWeb = new DriverDataForWeb(
					ConfigFactory.getConfig().browser(),
					ConfigFactory.getConfig().remoteMode());

			WebDriver driver = DriverFactory.getDriverForWeb(
					ConfigFactory.getConfig().runMode()).getDriver(
							driverDataWeb);

			DriverManager.setDriver(driver);
			
			loadURL();
		}

	}
	
	public static void loadURL() {
		DriverManager.getDriver().get(ConfigFactory.getConfig().weburl());
	}

	public static void initDriverMobile() {

		DriverDataForMobile driverDataMobile = new DriverDataForMobile(
				MobilePlatformType.ANDROID,
				ConfigFactory.getConfig().mobileRemoteMode());

		WebDriver driver = DriverFactory.getDriverForMobile(
				ConfigFactory.getConfig().mobileRunMode()).getDriver(
						driverDataMobile);

		DriverManager.setDriver(driver);
		//loadURL();
	}

	public static void quitDriver() {

		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
