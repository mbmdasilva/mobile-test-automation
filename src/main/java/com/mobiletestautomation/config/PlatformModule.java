package com.mobiletestautomation.config;

import com.google.inject.Module;

public enum PlatformModule {
    IOS {
        public Module getModule() {
            return new MyIosModule();
        }
    },
    ANDROID {
        public Module getModule() {
            return new MyAndroidModule();
        }
    };
    public abstract Module getModule();
}