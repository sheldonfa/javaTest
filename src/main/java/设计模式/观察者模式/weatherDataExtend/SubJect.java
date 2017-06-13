package 设计模式.观察者模式.weatherDataExtend;

/**
 * Created by Administrator on 2016/12/17.
 */
public interface SubJect {

    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}
