package com.core.automation.pages.web.orangehrm;

import org.openqa.selenium.By;

import com.core.automation.driver.enums.WaitStrategy;
import com.core.automation.utils.PageActionsHelper;

public class OrangeHRMLoginPage {
		
	private static final By USERNAME_TEXTBOX = By.xpath("//input[@name='username']");
	private static final By PASSWORD_TEXTBOX = By.xpath("//input[@name='password']");
	private static final By LOGIN_BUTTON = By.xpath("//button[@type='submit']");
	
	private OrangeHRMLoginPage setUserNameTextBox(String userName) {
		PageActionsHelper.waitAndSendKeys(USERNAME_TEXTBOX, userName, WaitStrategy.PRESENCE);
		return this;
	}
	
	private OrangeHRMLoginPage setPasswordTextBox(String password) {
		PageActionsHelper.waitAndSendKeys(PASSWORD_TEXTBOX, password, WaitStrategy.NONE);
		return this;
	}
	
	private OrangeHRMLoginPage setLoginButton() {
		PageActionsHelper.waitAndClick(LOGIN_BUTTON, WaitStrategy.CLICKABLE);
		return this;
	}
	
	public String getLoginPageTitle() {
		return PageActionsHelper.getPageTitle();
	}
	
	public OrangeHRMHomePage loginToApplication(String userName, String password) {
		
		setUserNameTextBox(userName).setPasswordTextBox(password).setLoginButton();
		
		return new OrangeHRMHomePage();
		
	}

}
