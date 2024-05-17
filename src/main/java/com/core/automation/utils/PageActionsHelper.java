package com.core.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.core.automation.driver.enums.WaitStrategy;
import com.core.automation.driver.factory.DriverManager;
import com.core.automation.driver.factory.ExplicitWaitFactory;

public class PageActionsHelper {

	private PageActionsHelper() {
	}

	public static String getPageTitle() {

		return DriverManager.getDriver().getTitle();
	}

	public static void waitAndClick(By by, WaitStrategy waitStrategy) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(by,
				waitStrategy);
		element.click();
	}

	public static void waitAndSendKeys(By by, String value,
			WaitStrategy waitStrategy) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(by,
				waitStrategy);
		element.sendKeys(value);
	}

}
