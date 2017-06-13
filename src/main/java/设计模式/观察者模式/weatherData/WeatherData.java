package 设计模式.观察者模式.weatherData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/17.
 */
public class WeatherData implements SubJect {

    private String temperature;
    private String humidity;
    private String pressure;

    // 维护一个列表，用于保存基本的观察者（订阅者）实例
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

    // 通知观察者，其实就是轮询调用观察者的update方法
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
