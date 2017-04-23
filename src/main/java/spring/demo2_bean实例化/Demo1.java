package spring.demo2_bean实例化;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 静态工厂实例化
 * 常应用于与第三方框架整合时
 * @author fangxin
 * @date 2017/4/22.
 */
public class Demo1 {

    public static void main(String[] args) {
        String classPath = "spring/applicationContext-service.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(classPath);
        Car car = context.getBean("carId", Car.class);
        car.run();

    }

}
