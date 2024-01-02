package com.core.automation.config.converters;

import java.lang.reflect.Method;

import org.aeonbits.owner.Converter;

import com.core.automation.config.enums.RunModeType;

public class ConvertStringToRunModeType implements Converter<RunModeType> {

	@Override
	public RunModeType convert(Method method, String remoteMode) {
		
		return RunModeType.valueOf(remoteMode.toUpperCase());
	}

}
