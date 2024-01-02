package com.core.automation.pages.web.orangehrm;

import org.openqa.selenium.By;

import com.core.automation.driver.enums.WaitStrategy;
import com.core.automation.utils.PageActionsHelper;

public class OrangeHRMHomePage {
	
	private static final By DROPDOWN_PROFILE = By.xpath("//div[@class='oxd-topbar-header-userarea']/ul/li[@class='oxd-userdropdown']");	
	private static final String PROFILE_MENU = "//ul[@class='oxd-dropdown-menu']/li/a[text()='%s']";
	
	private OrangeHRMHomePage setProfileDropdown() {
		PageActionsHelper.waitAndClick(DROPDOWN_PROFILE, WaitStrategy.PRESENCE);
		return this;
	}
	
	private OrangeHRMLoginPage setDropDownOption(String ddOption) {
		String xpath = String.format(PROFILE_MENU, ddOption);
		PageActionsHelper.waitAndClick(By.xpath(xpath), WaitStrategy.PRESENCE);
		return new OrangeHRMLoginPage();
	}
	
	public OrangeHRMLoginPage logoutOrangeHRMApplication(String menuName) {
		
	return	setProfileDropdown().setDropDownOption(menuName);
	}
	

}
