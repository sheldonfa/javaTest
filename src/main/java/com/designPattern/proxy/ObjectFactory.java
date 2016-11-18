package com.designPattern.proxy;

import com.designPattern.proxy.service.AccountService;
import com.designPattern.proxy.service.AccountServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2016/11/16 0016.
 */
public class ObjectFactory {

    public static AccountService getAccountService(){
        final AccountService service = new AccountServiceImpl();

        AccountService proxy = (AccountService)Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), new InvocationHandler(){
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object invoke = null;
                /**
                 * 这里的if判断一定要有，如果没有，debug和run完全不一样，原因是：被代理对象中有隐藏的toString方法，debug的时候反复触发，导致数据链接被关闭
                 */
                System.out.println("invoke调用了这个方法"+method.getName());
                if("transfer2".equals(method.getName())) {
                    try {
                        System.out.println("方法名称" + method.getName());
                        //这个地方不能打断点 否则事务不回滚，令人费解
                        ManagerThreadLocal.startTransaction();
                        invoke = method.invoke(service, args);
                        ManagerThreadLocal.commit();
                    } catch (Exception e) {
                        try {
                            ManagerThreadLocal.rollback();//回滚事务
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    } finally {
                        try {
                            ManagerThreadLocal.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }//关闭
                    }
                }
                return invoke;
            }
        });
        return proxy;
    }
}
