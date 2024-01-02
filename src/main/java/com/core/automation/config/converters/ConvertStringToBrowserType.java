package com.core.automation.config.converters;

import java.lang.reflect.Method;
import java.util.Map;

import org.aeonbits.owner.Converter;

import com.core.automation.config.enums.BrowserType;

public class ConvertStringToBrowserType implements Converter<BrowserType> {

	@Override
	public BrowserType convert(Method method, String browserName) {
		Map<String, BrowserType> stringBrowserMap = Map.of("CHROME",
				BrowserType.CHROME, "FIREFOX", BrowserType.FIREFOX);
		return stringBrowserMap.getOrDefault(browserName.toUpperCase(),
				BrowserType.CHROME);
	}

}
