package com.core.automation.driver.factory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.core.automation.config.factory.ConfigFactory;
import com.core.automation.driver.enums.WaitStrategy;

public final class ExplicitWaitFactory {

	private ExplicitWaitFactory() {
	}

	public static WebElement performExplicitWait(By by,
			WaitStrategy waitStrategy) {
		WebElement element = null;
		if (waitStrategy == WaitStrategy.CLICKABLE) {

			element = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(ConfigFactory.getConfig().explicitwait()))
					.until(ExpectedConditions.elementToBeClickable(by));

		} else if (waitStrategy == WaitStrategy.PRESENCE) {

			element = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(ConfigFactory.getConfig().explicitwait()))
					.until(ExpectedConditions.presenceOfElementLocated(by));

		} else if (waitStrategy == WaitStrategy.VISIBLE) {

			element = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(ConfigFactory.getConfig().explicitwait()))
					.until(ExpectedConditions.visibilityOfElementLocated(by));

		} else if (waitStrategy == WaitStrategy.NONE) {

			element = DriverManager.getDriver().findElement(by);

		}

		return element;

	}
}
