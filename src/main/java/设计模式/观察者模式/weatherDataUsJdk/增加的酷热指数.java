package 设计模式.观察者模式.weatherDataUsJdk;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Administrator on 2016/12/17.
 *
 */
public class 增加的酷热指数 implements Observer,Display {

    private String temperature;
    private String humidity;
    private String pressure;
    Observable observable;

    public 增加的酷热指数(Observable observable) {
        this.observable = observable;
        // 观察者订阅自己
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
//        if(o instanceof WeatherData){
//            this.temperature = ((WeatherData) o).getTemperature();
//            this.humidity = ((WeatherData) o).getHumidity();
//            this.pressure = ((WeatherData) o).getPressure();
//            display();
//        }
        /**
         * 如果是“拉”，直接用已知observable即可，根本不需要用update传过来的o，组合模式轻松搞定。
         */
        if(observable instanceof WeatherData){
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
        return "增加的酷热指数{" +
                "temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                ", pressure='" + pressure + '\'' +
                '}';
    }
}
