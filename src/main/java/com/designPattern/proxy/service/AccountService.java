package com.designPattern.proxy.service;

import java.sql.SQLException;

/**
 * Created by Administrator on 2016/11/16 0016.
 */
public interface AccountService {

//    void transfer(String fromName, String toName, Double money);

    void transfer2(String fromName, String toName, Double money) throws SQLException;
}
