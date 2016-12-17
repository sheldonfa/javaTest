package com.designPattern.observer.weatherDataExtend;

/**
 * Created by Administrator on 2016/12/17.
 */
public class 天气预报 implements Observer,Display {

    private String temperature;
    private String humidity;
    private String pressure;
    private SubJect weatherData;

    /**
     * 创建天气预报布告的时候，需要主题，并注册自己
     * @param weatherData
     */
    public 天气预报(SubJect weatherData) {
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
        return "天气预报{" +
                "temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                ", pressure='" + pressure + '\'' +
                '}';
    }
}
