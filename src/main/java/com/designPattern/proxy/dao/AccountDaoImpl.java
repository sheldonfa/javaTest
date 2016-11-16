package com.designPattern.proxy.dao;

import com.DBUtils.ManagerThreadLocal;
import com.DBUtils.model.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/11/16 0016.
 */
public class AccountDaoImpl implements AccountDao {

    private Connection conn;

    public AccountDaoImpl() {
    }

    public AccountDaoImpl(Connection conn) {
        this.conn = conn;
    }

    public void updateAccount(Account account) throws SQLException {
        QueryRunner qr = new QueryRunner();
        qr.update(conn,"update account set money=? where name=?", account.getMoney(), account.getName());
    }

    public Account findAccountByName(String name) throws SQLException {
        QueryRunner qr = new QueryRunner();
        return qr.query(conn,"select * from account where name=?", new BeanHandler<Account>(Account.class), name);
    }

    public void updateAccount2(Account account) throws SQLException {
        QueryRunner qr = new QueryRunner();
        qr.update(ManagerThreadLocal.getConnection(),"update account set money=? where name=?", account.getMoney(), account.getName());
    }

    public Account findAccountByName2(String name) throws SQLException {
        QueryRunner qr = new QueryRunner();
        return qr.query(ManagerThreadLocal.getConnection(),"select * from account where name=?", new BeanHandler<Account>(Account.class), name);
    }
}
