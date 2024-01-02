package com.core.automation.config.factory;

import org.aeonbits.owner.ConfigCache;

import com.core.automation.config.SauceLabsConfig;

public final class SauceLabsConfigFactory {

	private SauceLabsConfigFactory() {}

	public static SauceLabsConfig getConfig() {
		return ConfigCache.getOrCreate(SauceLabsConfig.class);
	}

}
