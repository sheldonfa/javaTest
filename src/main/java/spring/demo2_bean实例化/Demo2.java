package spring.demo2_bean实例化;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 实例工厂
 * @author fangxin
 * @date 2017/4/22.
 */
public class Demo2 {

    public static void main(String[] args) {
        String classPath = "spring/applicationContext-service.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(classPath);
        Car car = context.getBean("carId2", Car.class);
        car.run();
    }

}
