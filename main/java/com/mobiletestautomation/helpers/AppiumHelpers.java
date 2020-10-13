package com.mobiletestautomation.helpers;

import com.google.inject.Inject;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppiumHelpers {
    private AppiumDriver appiumDriver;
    private WebDriverWait webDriverWait;

    @Inject
    public  AppiumHelpers(AppiumDriver appiumDriver, WebDriverWait webDriverWait){
        this.appiumDriver = appiumDriver;
        this.webDriverWait = webDriverWait;
    }

    //wait for element by Id
    public void waitForElementById(String mobileElementId) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(mobileElementId)));
    }
}
