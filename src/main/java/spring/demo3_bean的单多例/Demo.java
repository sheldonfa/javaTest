package spring.demo3_bean的单多例;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring bean的单多例控制
 * @author fangxin
 * @date 2017/4/22.
 */
public class Demo {

    public static void main(String[] args) {
        String classPath = "spring/applicationContext-service.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(classPath);
        Dog dog1 = context.getBean("dogId1", Dog.class);
        Dog dog2 = context.getBean("dogId1", Dog.class);
        Dog dog3 = context.getBean("dogId2", Dog.class);
        Dog dog4 = context.getBean("dogId2", Dog.class);

        System.out.println(dog1==dog2);
        System.out.println(dog3==dog4);
    }

}
