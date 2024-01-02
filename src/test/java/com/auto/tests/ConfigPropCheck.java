package com.auto.tests;


import org.testng.annotations.Test;

import com.core.automation.config.factory.ConfigFactory;

class ConfigPropCheck {
	
	@Test
	void configCheckMethod() {
		System.out.println("Proxy Details:: "+ConfigFactory.getConfig().proxySettings());
	}

}
