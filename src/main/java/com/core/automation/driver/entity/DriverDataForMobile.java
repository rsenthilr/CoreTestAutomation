package com.core.automation.driver.entity;

import com.core.automation.config.enums.MobilePlatformType;
import com.core.automation.config.enums.MobileRemoteModeType;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DriverDataForMobile {
	private MobilePlatformType mobilePlatformType;
	private MobileRemoteModeType mobileRemoteModeType;
}
