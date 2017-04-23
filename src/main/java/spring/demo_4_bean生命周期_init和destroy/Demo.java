package spring.demo_4_bean生命周期_init和destroy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * bean生命周期 init和destroy
 * @author fangxin
 * @date 2017/4/22.
 */
public class Demo {

    public static void main(String[] args) {
        String classPath = "spring/applicationContext-service.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(classPath);
        Cat cat1 = context.getBean("catId1", Cat.class);
        Cat cat2 = context.getBean("catId2", Cat.class);
        cat1.run();
        // 实例必须是单例，才会触发destroy方法
        cat2.run();
        // 容器必须close才会触发destroy方法
        context.close();
    }

}
