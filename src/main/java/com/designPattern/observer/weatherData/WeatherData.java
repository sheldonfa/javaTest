package com.designPattern.observer.weatherData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/17.
 */
public class WeatherData implements SubJect {

    private String temperature;
    private String humidity;
    private String pressure;
    private List<Observer> observers;

    public WeatherData() {
        this.observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if(observers.indexOf(o)>0){
            observers.remove(o);
        }
    }

    @Override
    public void notifyObservers() {
        this.temperature = getTemperature();
        this.humidity = getHumidity();
        this.pressure = getPressure();
        for(Observer o: observers){
            o.update(temperature,humidity,pressure);
        }
    }

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
        notifyObservers();
    }

    public void simulateMeasureChange(String temperature,String humidity,String pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measureChanged();
    }
}
