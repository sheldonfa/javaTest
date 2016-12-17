package com.designPattern.observer.weatherDataExtend;

/**
 * Created by Administrator on 2016/12/17.
 */
public class 气象统计 implements Observer,Display {

    private String temperature;
    private String humidity;
    private String pressure;
    private SubJect weatherData;

    public 气象统计(SubJect weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(String temperature, String humidity, String pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.display();
    }

    @Override
    public void display() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "气象统计{" +
                "temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                ", pressure='" + pressure + '\'' +
                '}';
    }
}
