package spring.demo_7_aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author fangxin
 * @date 2017/4/23.
 */
public class MyAspect implements MethodInterceptor{


    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        System.out.println("前面");
        Object obj = methodInvocation.proceed();
        System.out.println("后面");

        return obj;
}
}
