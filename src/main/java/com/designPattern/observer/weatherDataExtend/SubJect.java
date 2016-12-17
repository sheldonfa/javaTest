package com.designPattern.observer.weatherDataExtend;

/**
 * Created by Administrator on 2016/12/17.
 */
public interface SubJect {

    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}
