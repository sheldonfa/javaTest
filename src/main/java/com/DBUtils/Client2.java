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
     *
     * @from https://www.zhihu.com/question/23089780
     * ☆☆☆☆ThreadLocal的作用是提供线程内的局部变量，这种变量在线程的生命周期内起作用，减少同一个线程内多个函数或者组件之间一些公共变量的传递的复杂度。
     *
     * 举个例子，我出门需要先坐公交再做地铁，这里的坐公交和坐地铁就好比是同一个线程内的两个函数，我就是一个线程，我要完成这两个函数都需要同一个东西：公交卡（北京公交和地铁都使用公交卡），那么我为了不向这两个函数都传递公交卡这个变量（相当于不是一直带着公交卡上路），我可以这么做：将公交卡事先交给一个机构，当我需要刷卡的时候再向这个机构要公交卡（当然每次拿的都是同一张公交卡）。这样就能达到只要是我(同一个线程)需要公交卡，何时何地都能向这个机构要的目的。
    有人要说了：你可以将公交卡设置为全局变量啊，这样不是也能何时何地都能取公交卡吗？但是如果有很多个人（很多个线程）呢？大家可不能都使用同一张公交卡吧(我们假设公交卡是实名认证的)，这样不就乱套了嘛。现在明白了吧？这就是ThreadLocal设计的初衷：提供线程内部的局部变量，在本线程内随时随地可取，隔离其他线程。

     * @from http://blog.csdn.net/qjyong/article/details/2158097
     * ThreadLocal是解决线程安全问题一个很好的思路，它通过为每个线程提供一个独立的变量副本解决了变量并发访问的冲突问题。在很多情况下，ThreadLocal比直接使用synchronized同步机制解决线程安全问题更简单，更方便，且结果程序拥有更高的并发性。
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
