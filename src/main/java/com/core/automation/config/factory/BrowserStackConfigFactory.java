package com.core.automation.config.factory;

import org.aeonbits.owner.ConfigCache;

import com.core.automation.config.BrowserStackConfig;

public final class BrowserStackConfigFactory {

	private BrowserStackConfigFactory() {}

	public static BrowserStackConfig getConfig() {
		return ConfigCache.getOrCreate(BrowserStackConfig.class);
	}

}
