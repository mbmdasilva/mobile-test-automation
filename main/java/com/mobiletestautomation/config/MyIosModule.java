package com.mobiletestautomation.config;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.mobiletestautomation.contracts.Home;
import com.mobiletestautomation.screens.ios.HomeScreen;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.URL;

public class MyIosModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Home.class).to(HomeScreen.class);

    }

    @Provides
    @Singleton
    public Config configProvider() {
        Config config = ConfigFactory.load();
        String env = config.getString("environment");
        return config.getConfig(config.getString("environment")).withFallback(config);
    }

    @Provides
    @Singleton
    public AppiumDriver providesAppiumDriver(Config config) throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","iOS");
        capabilities.setCapability("platfromVersion","13.3");
        capabilities.setCapability("deviceName","iPhone 11");
        capabilities.setCapability("automationName","XCUITest");
        capabilities.setCapability("noReset","false");
        capabilities.setCapability("app", config.getString("ios.app.path"));
        return new io.appium.java_client.ios.IOSDriver<>( new URL(String.format("http://localhost:%d/wd/hub", config.getInt("ios.server.port"))),capabilities);
    }

    @Provides
    public WebDriverWait provideWebDriverWait(AppiumDriver appiumDriver) {
        WebDriverWait wait = new WebDriverWait(appiumDriver, Defaults.WAIT_TIME.getTime());
        wait.ignoring(NoSuchElementException.class);
        return wait;
    }
}