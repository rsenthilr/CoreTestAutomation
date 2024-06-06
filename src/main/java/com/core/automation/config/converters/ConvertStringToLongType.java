package com.core.automation.config.converters;

import java.lang.reflect.Method;

import org.aeonbits.owner.Converter;

import lombok.SneakyThrows;

public class ConvertStringToLongType implements Converter<Long>{

	@SneakyThrows
	@Override
	public Long convert(Method method, String duration) {
		
		return duration.isEmpty()?Long.parseLong("15"):Long.parseLong(duration);
	}

}
