package com.designPattern.observer.weatherDataUsJdk;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Administrator on 2016/12/17.
 *
 */
public class 当前状况 implements Observer,Display {

    private String temperature;
    private String humidity;
    private String pressure;
    Observable observable;

    public 当前状况(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData){
            this.temperature = ((WeatherData) o).getTemperature();
            this.humidity = ((WeatherData) o).getHumidity();
            this.pressure = ((WeatherData) o).getPressure();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "当前状况{" +
                "temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                ", pressure='" + pressure + '\'' +
                '}';
    }
}
