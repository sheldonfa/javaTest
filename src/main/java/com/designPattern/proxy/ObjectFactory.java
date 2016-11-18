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

        AccountService proxy = (AccountService)Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object invoke = null;
                try{
                    //这个地方不能打断点 否则事务不回滚，令人费解
                    ManagerThreadLocal.startTransaction();
                    invoke = method.invoke(service, args);
                    ManagerThreadLocal.commit();
                }catch(Exception e){
                    try {
                        ManagerThreadLocal.rollback();//回滚事务
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }finally{
                    try {
                        ManagerThreadLocal.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }//关闭
                }
                return invoke;
            }
        });
        return proxy;
    }
}
