package com.core.automation.driver.entity;

import com.core.automation.config.enums.BrowserType;
import com.core.automation.config.enums.RemoteModeType;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DriverDataForWeb {
	private BrowserType browserType;
	private RemoteModeType remoteModeType;
}
