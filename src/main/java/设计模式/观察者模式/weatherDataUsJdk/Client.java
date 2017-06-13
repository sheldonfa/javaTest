package 设计模式.观察者模式.weatherDataUsJdk;

/**
 * Created by Administrator on 2016/12/17.
 *
 */
public class Client {

    public static void main(String[] args) {
        WeatherData w = new WeatherData();

        当前状况 a = new 当前状况(w);
        new 气象统计(w);
        new 天气预报(w);
        /**
         * 当我增加酷热指数布告的时候，我没有改变任何代码，除了它本身
         */
        new 增加的酷热指数(w);

        w.simulateMeasureChange("15","20","35");
        w.simulateMeasureChange("16","20","35");
        w.simulateMeasureChange("17","20","35");
    }

}
