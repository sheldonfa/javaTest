package com.designPattern.proxy;

import com.designPattern.proxy.service.AccountService;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by Administrator on 2016/11/16 0016.
 * 代理模式
 */
public class Client {

    /**
     * AOP+动态代理 解决转账事务
     */
    @Test
    public void testAccountWithAOP() throws Exception {
        AccountService service = ObjectFactory.getAccountService();
        service.transfer2("zhangsan","lisi",1d);
    }
}
