package com.core.automation.config.converters;

import java.lang.reflect.Method;
import java.time.Duration;

import org.aeonbits.owner.Converter;

import lombok.SneakyThrows;

public class ConvertStringToDurationType implements Converter<Duration> {

	@SneakyThrows
	@Override
	public Duration convert(Method method, String duration) {
		
		return !"".equals(duration) ? Duration.ofSeconds(Long.parseLong(duration)) : Duration.ofSeconds(10);
	}

}
