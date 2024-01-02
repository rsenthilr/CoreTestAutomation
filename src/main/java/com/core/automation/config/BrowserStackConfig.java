package com.core.automation.config;

import java.net.URL;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;

import com.core.automation.config.converters.ConvertStringToURLType;



@LoadPolicy(LoadType.MERGE)
@Sources({
	 "file:${user.dir}/src/test/resources/browserstack.properties"
    })
public interface BrowserStackConfig extends Config{

	@Key("username")
	String userName();
	
	@Key("key")
	String key();

	@DefaultValue("https://${username}:${key}@hub-cloud.browserstack.com/wd/hub")
	@ConverterClass(ConvertStringToURLType.class)
	URL browserStackURL();

}
