package com.designPattern.observer.weatherDataUsJdk;

import java.util.Observable;

/**
 * Created by Administrator on 2016/12/17.
 *
 */
public class WeatherData extends Observable {

    private String temperature;
    private String humidity;
    private String pressure;

    /**
     * 不需要追踪观察者了，也不需要为观察者建立数据结构了
     */
    public WeatherData() {}

    public String getTemperature() {
        return temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getPressure() {
        return pressure;
    }

    /**
     * 气温有变化时立即调用
     */
    public void measureChanged(){
        setChanged();
        notifyObservers();
    }

    public void simulateMeasureChange(String temperature,String humidity,String pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measureChanged();
    }
}
