package 设计模式.观察者模式.weatherDataExtend;

/**
 * Created by Administrator on 2016/12/17.
 */
public class 当前状况 implements Observer,Display {

    private String temperature;
    private String humidity;
    private String pressure;
    private SubJect weatherData;

    public 当前状况(SubJect weatherData) {
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
        return "当前状况{" +
                "temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                ", pressure='" + pressure + '\'' +
                '}';
    }
}
