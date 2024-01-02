package com.core.automation.config;

import java.net.URL;
import java.time.Duration;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;

import com.core.automation.config.converters.ConvertStringToBrowserType;
import com.core.automation.config.converters.ConvertStringToDurationType;
import com.core.automation.config.converters.ConvertStringToMobileRemoteModeType;
import com.core.automation.config.converters.ConvertStringToMobileRunModeType;
import com.core.automation.config.converters.ConvertStringToRemoteModeType;
import com.core.automation.config.converters.ConvertStringToRunModeType;
import com.core.automation.config.converters.ConvertStringToURLType;
import com.core.automation.config.enums.BrowserType;
import com.core.automation.config.enums.MobileRemoteModeType;
import com.core.automation.config.enums.MobileRunModeType;
import com.core.automation.config.enums.RemoteModeType;
import com.core.automation.config.enums.RunModeType;

@LoadPolicy(LoadType.MERGE)
@Sources({
	"system:properties",
	"system:env",
	"file:${user.dir}/src/test/resources/config.properties",
	"file:${user.dir}/src/test/resources/staging-config.properties",
	"file:${user.dir}/src/test/resources/dev-config.properties"})
public interface FrameworkConfig extends Config {

	//---------General Configurations: STARTS---------//
	
	@DefaultValue("10")
	@Key("ExplicitWait")
	@ConverterClass(ConvertStringToDurationType.class)
	Duration explicitwait();
	
	@DefaultValue("10")
	@Key("PageLoadTimeOuts")
	@ConverterClass(ConvertStringToDurationType.class)
	Duration pageloadtimeouts();
	
	@Key("Proxy")
	String proxySettings();
	
	//---------General Configurations: ENDS---------//
	
	//---------Configurations for WEB: STARTS---------//
	
	@DefaultValue("staging")
	String environment();
	
	@Key("${environment}.weburl")
	String weburl();
		
	@DefaultValue("CHROME")
	@ConverterClass(ConvertStringToBrowserType.class)
	BrowserType browser();
	
	@Key("runMode")
	@ConverterClass(ConvertStringToRunModeType.class)
	RunModeType runMode();
	
	@Key("remoteMode")
	@ConverterClass(ConvertStringToRemoteModeType.class)
	RemoteModeType remoteMode();
	
	@ConverterClass(ConvertStringToURLType.class)
	URL seleniumGridURL();
	
	@ConverterClass(ConvertStringToURLType.class)
	URL selenoidURL();
	
	@ConverterClass(ConvertStringToURLType.class)
	URL browserStackURL();
	
	//---------Configurations for WEB: ENDS---------//
	
	//---------Configuration for Mobile: STARTS-------//
	@Key("mobileRunMode")
	@ConverterClass(ConvertStringToMobileRunModeType.class)
	MobileRunModeType mobileRunMode();
	
	@Key("mobileRemoteMode")
	@ConverterClass(ConvertStringToMobileRemoteModeType.class)
	MobileRemoteModeType mobileRemoteMode();
	
	@DefaultValue("http://127.0.0.1:4723/wd/hub")
	@ConverterClass(ConvertStringToURLType.class)
	URL LocalAppiumServerURL();
	
	//---------Configuration for Mobile: ENDS-------
	
}
