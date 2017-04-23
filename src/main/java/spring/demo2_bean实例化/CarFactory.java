package spring.demo2_bean实例化;

/**
 * @author fangxin
 * @date 2017/4/22.
 */
public class CarFactory {

    /**
     * 静态工厂
     */
    public static Car createCar(){
        return new Car();
    }

    /**
     * 实例工厂
     * 使用实例工厂方法，必须要创建工厂实例
     */
    public Car getCarInstance(){
        return new Car();
    }

}
