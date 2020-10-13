package com.mobiletestautomation.config;

public enum Defaults {
    WAIT_TIME(40);

    private final int time;

    Defaults(int time){
        this.time = time;
    }

    public int getTime(){
        return time;
    }
}