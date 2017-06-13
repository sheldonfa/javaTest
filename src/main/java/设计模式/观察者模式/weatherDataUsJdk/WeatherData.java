package 设计模式.观察者模式.weatherDataUsJdk;

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
        // 只有调用了setChanged()方法，notifyObservers才会认为真的改变了数据，才有可能通知观察者，这个设计是为了细粒度的控制通知
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
