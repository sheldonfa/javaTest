package com.designPattern.observer.weatherDataExtend;

/**
 * Created by Administrator on 2016/12/17.
 */
public class Client {

    public static void main(String[] args) {
        WeatherData w = new WeatherData();

        new 当前状况(w);
        new 气象统计(w);
        new 天气预报(w);
        /**
         * 当我增加酷热指数布告
         */
        new 增加的酷热指数(w);

        w.simulateMeasureChange("15","20","35");
        w.simulateMeasureChange("16","20","35");
        w.simulateMeasureChange("17","20","35");
    }

}
