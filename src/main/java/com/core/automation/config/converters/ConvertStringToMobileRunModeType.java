package com.core.automation.config.converters;

import java.lang.reflect.Method;

import org.aeonbits.owner.Converter;

import com.core.automation.config.enums.MobileRunModeType;

public class ConvertStringToMobileRunModeType implements Converter<MobileRunModeType> {

	@Override
	public MobileRunModeType convert(Method method, String mobileRunMode) {
		
		return MobileRunModeType.valueOf(mobileRunMode.toUpperCase());
	}

}
