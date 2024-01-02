package com.core.automation.config.converters;

import java.lang.reflect.Method;

import org.aeonbits.owner.Converter;

import com.core.automation.config.enums.MobileRemoteModeType;

public class ConvertStringToMobileRemoteModeType implements Converter<MobileRemoteModeType> {

	@Override
	public MobileRemoteModeType convert(Method method, String mobileRemoteMode) {
		
		return MobileRemoteModeType.valueOf(mobileRemoteMode.toUpperCase());
	}

}
