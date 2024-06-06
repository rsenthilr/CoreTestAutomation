package com.auto.tests;


import org.testng.annotations.Test;

import com.core.automation.config.factory.ConfigFactory;

class ConfigPropCheck {
	
	@Test
	void configCheckMethod() {
		System.out.println("Proxy Details:: "+ConfigFactory.getConfig().proxySettings());
		System.out.println("ExplicitWait Details:: "+ConfigFactory.getConfig().explicitwait());
		System.out.println("PageLoadTimeout Details:: "+ConfigFactory.getConfig().pageloadtimeouts());
	}

}
