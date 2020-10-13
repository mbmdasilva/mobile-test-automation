package com.mobiletestautomation.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;
import io.cucumber.guice.CucumberModules;
import io.cucumber.guice.InjectorSource;

public class MyInjector implements InjectorSource {
    @Override
    public Injector getInjector() {
        String chosenPlatform = Environment.requiredSystemProperty("platform");
        String env = Environment.requiredSystemProperty("env");
        return Guice.createInjector(Stage.PRODUCTION, CucumberModules.createScenarioModule(), PlatformModule.valueOf(chosenPlatform).getModule());
    }
}