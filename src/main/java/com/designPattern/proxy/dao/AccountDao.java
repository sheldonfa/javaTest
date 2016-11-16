package com.designPattern.proxy.dao;

import com.DBUtils.model.Account;

import java.sql.SQLException;

/**
 * Created by Administrator on 2016/11/16 0016.
 */
public interface AccountDao {

    void updateAccount(Account account) throws SQLException;

    Account findAccountByName(String name) throws SQLException;

    void updateAccount2(Account account) throws SQLException;

    Account findAccountByName2(String name) throws SQLException;

}
