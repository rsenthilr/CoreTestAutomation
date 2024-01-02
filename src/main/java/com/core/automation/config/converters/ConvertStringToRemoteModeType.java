package com.core.automation.config.converters;

import java.lang.reflect.Method;
import java.util.Map;

import org.aeonbits.owner.Converter;

import com.core.automation.config.enums.RemoteModeType;

public class ConvertStringToRemoteModeType
		implements
			Converter<RemoteModeType> {

	@Override
	public RemoteModeType convert(Method method, String remoteMode) {
		Map<String, RemoteModeType> stringRemoteMode = Map.of(
				"SELENIUMGRID", RemoteModeType.SELENIUMGRID, 
				"SELENOID", RemoteModeType.SELENOID, 
				"BROWSERSTACK", RemoteModeType.BROWSERSTACK
				);
		
		return stringRemoteMode.getOrDefault(remoteMode.toUpperCase(), RemoteModeType.BROWSERSTACK);
	}

}
