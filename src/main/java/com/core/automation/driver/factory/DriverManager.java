package com.core.automation.driver.factory;

import java.util.EnumMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.core.automation.driver.enums.ContextType;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public final class DriverManager {
	
	private DriverManager() {}
	
	//Context
	// web
	// mobile
	// web ---> mobile
	// web ---> mobile ---> web
	// Map ---> WEB, WEB_DRIVER_THREAD_LOCAL / MOBILE, MOBILE_DRIVER_THREAD_LOCAL
	// Check at a particular instance to know which context its: WEB / MOBILE
	
	private static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new ThreadLocal<>();
	private static final ThreadLocal<WebDriver> MOBILE_DRIVER_THREAD_LOCAL = new ThreadLocal<>();
	private static final ThreadLocal<ContextType> CONTEXT = ThreadLocal.withInitial(() -> ContextType.WEB);
	
	private static final Map<ContextType, ThreadLocal<WebDriver>> DRIVER_MAP = new EnumMap<>(ContextType.class);
	
	
	public static WebDriver getDriver() {
		return CONTEXT.get() == ContextType.WEB 
				? WEB_DRIVER_THREAD_LOCAL.get() 
				: MOBILE_DRIVER_THREAD_LOCAL.get();
	}

	public static void setDriver(WebDriver driver) {
		if(isMobileDriver(driver)) {
			MOBILE_DRIVER_THREAD_LOCAL.set(driver);
			DRIVER_MAP.put(ContextType.MOBILE, MOBILE_DRIVER_THREAD_LOCAL);
			CONTEXT.set(ContextType.MOBILE);
			
		} else {
			WEB_DRIVER_THREAD_LOCAL.set(driver);
			DRIVER_MAP.put(ContextType.WEB, WEB_DRIVER_THREAD_LOCAL);
			CONTEXT.set(ContextType.WEB);
		}
	}

	private static boolean isMobileDriver(WebDriver driver) {
		
		return driver instanceof AndroidDriver || driver instanceof IOSDriver;
	}
	
	public static void unload() {
		
		WEB_DRIVER_THREAD_LOCAL.remove();
		MOBILE_DRIVER_THREAD_LOCAL.remove();
		CONTEXT.remove();		
	}
}
