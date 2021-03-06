package 设计模式.观察者模式.weatherDataUsJdk;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Administrator on 2016/12/17.
 *
 */
public class 天气预报 implements Observer,Display {

    private String temperature;
    private String humidity;
    private String pressure;
    Observable observable;

    /**
     * 创建天气预报布告的时候，需要主题，并注册自己
     * @param observable
     */
    public 天气预报(Observable observable) {
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
        return "天气预报{" +
                "temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                ", pressure='" + pressure + '\'' +
                '}';
    }
}
