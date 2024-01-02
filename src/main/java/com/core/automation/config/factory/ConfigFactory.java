package com.core.automation.config.factory;

import org.aeonbits.owner.ConfigCache;

import com.core.automation.config.FrameworkConfig;

public final class ConfigFactory {
 private ConfigFactory() {}
 
 public static FrameworkConfig getConfig() {
	 return ConfigCache.getOrCreate(FrameworkConfig.class);
 }
}
