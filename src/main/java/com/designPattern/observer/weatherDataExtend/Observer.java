package com.designPattern.observer.weatherDataExtend;

/**
 * Created by Administrator on 2016/12/17.
 */
public interface Observer {

    void update(String temperature, String humidity, String pressure);
}
