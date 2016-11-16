package com.DBUtils.dao;

import com.DBUtils.model.Account;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2016/11/16 0016.
 */
public interface AccountDao {

    void updateAccount(Account account) throws SQLException;

    Account findAccountByName(String name) throws SQLException;

}
