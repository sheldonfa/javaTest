package com.DBUtils;

import com.DBUtils.model.Account;
import com.DBUtils.service.AccountService;
import com.DBUtils.service.AccountServiceImpl;
import org.junit.Test;

/**
 * Created by Administrator on 2016/11/16 0016.
 */
public class Client2 {

    /**
     * 案例1：转账之————一个连接对应一个事务
     */
    @Test
    public void account(){
        AccountService account = new AccountServiceImpl();
        account.transfer("zhangsan","lisi",100d);
    }

    /**
     * 外例：TreadLocal：线程的局部变量
     * 特点：每个线程都有自己的ThreadLocal，并且相互独立、互不干扰
     */
    @Test
    public void testThreadLocal(){
        ThreadLocal tl = new ThreadLocal();
        tl.set("aaa");
//        System.out.println(tl.get()); // 本地线程调用get()方法可以获取之前设置的内容
        MyThread mt = new MyThread(tl);
        mt.start();
    }

    /**
     * 案例二：转账之————解决事务的链接代码入侵业务层
     */
    @Test
    public void testAccount2(){
        AccountService account = new AccountServiceImpl();
        account.transfer2("zhangsan","lisi",10d);
    }
}
