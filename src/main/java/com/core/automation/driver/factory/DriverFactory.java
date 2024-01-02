package com.core.automation.driver.factory;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

import com.core.automation.config.enums.MobileRunModeType;
import com.core.automation.config.enums.RunModeType;
import com.core.automation.driver.impl.mobile.LocalMobileDriverImpl;
import com.core.automation.driver.impl.mobile.RemoteMobileDriverImpl;
import com.core.automation.driver.impl.web.LocalDriverWebImpl;
import com.core.automation.driver.impl.web.RemoteDriverWebImpl;

public final class DriverFactory {

	private DriverFactory() {
	}
	
	public static final Map<RunModeType, Supplier<IWebDriver>> WEB = new EnumMap<>(RunModeType.class);
	public static final Map<MobileRunModeType, Supplier<IMobileDriver>> MOBILE = new EnumMap<>(MobileRunModeType.class);
	
	static {
		WEB.put(RunModeType.LOCAL, LocalDriverWebImpl::new);
		WEB.put(RunModeType.REMOTE, RemoteDriverWebImpl::new);
		MOBILE.put(MobileRunModeType.LOCAL, LocalMobileDriverImpl::new);
		MOBILE.put(MobileRunModeType.REMOTE, RemoteMobileDriverImpl::new);
	}

	public static IWebDriver getDriverForWeb(RunModeType runModeType) {
		
		return WEB.get(runModeType).get();

	}

	public static IMobileDriver getDriverForMobile(MobileRunModeType mobileRunModeType) {

		return MOBILE.get(mobileRunModeType).get();
		
	}

}
