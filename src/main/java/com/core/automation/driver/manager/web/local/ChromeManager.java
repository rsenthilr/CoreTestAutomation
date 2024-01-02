package com.core.automation.driver.manager.web.local;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.core.automation.config.factory.ConfigFactory;

public final class ChromeManager {
	
	private ChromeManager() {}
	
	public static WebDriver getDriver() {	
		
		  ChromeOptions options = new ChromeOptions(); 
		  Proxy proxy = new Proxy(); 
		  proxy.setSslProxy(ConfigFactory.getConfig().proxySettings());
		  options.setProxy(proxy);
		
		  return new ChromeDriver(options);		
	}

}
