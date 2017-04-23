package spring.demo_5_bean生命周期_bean后处理器;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * bean后处理器，所有对象初始化都会调用这个方法
 * @author fangxin
 * @date 2017/4/22.
 */
public class MyBeanPostProcessor implements BeanPostProcessor{

    // 在init方法前执行
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化前");
        return bean;
    }

    // 在init方法后执行
    @Override
    public Object postProcessAfterInitialization(final Object bean, String beanName) throws BeansException {

        return Proxy.newProxyInstance(MyBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开启事务");
                Object obj = method.invoke(bean, args);
                System.out.println("关闭事务");
                return obj;
            }
        });
    }
}
