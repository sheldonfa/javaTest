package com.DBUtils;

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
}
