package com.mobiletestautomation.screens.ios;

import com.google.inject.Inject;
import com.mobiletestautomation.contracts.Home;
import com.mobiletestautomation.helpers.AppiumHelpers;
import com.mobiletestautomation.screens.Base;
import io.appium.java_client.AppiumDriver;

public class HomeScreen extends Base implements Home {
    private final AppiumDriver appiumDriver;
    private final AppiumHelpers appiumHelpers;

    @Inject
    public HomeScreen(AppiumDriver appiumDriver, AppiumHelpers appiumHelpers) {
        super(appiumDriver);
        this.appiumDriver = appiumDriver;
        this.appiumHelpers = appiumHelpers;
    }
}