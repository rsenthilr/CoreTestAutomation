package com.core.automation.config;

import java.net.URL;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.Sources;

import com.core.automation.config.converters.ConvertStringToURLType;

@LoadPolicy(Config.LoadType.MERGE)
@Sources({
        "file:${user.dir}/src/test/resources/sauce-labs.properties"
})
public interface SauceLabsConfig extends Config{

	@Key("username")
	String userName();

	String key();

	@DefaultValue("saucelabsendpoint")
	@ConverterClass(ConvertStringToURLType.class)
	URL sauceLabsURL();

}
