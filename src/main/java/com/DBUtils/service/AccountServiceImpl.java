package com.DBUtils.service;

import com.DBUtils.dao.AccountDao;
import com.DBUtils.dao.AccountDaoImpl;
import com.DBUtils.model.Account;
import com.connectPool.C3P0Utils;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/11/16 0016.
 */
public class AccountServiceImpl implements AccountService{


    public void transfer(String fromName,String toName,Double money){
        Connection conn = C3P0Utils.getConnection();
        AccountDao dao = new AccountDaoImpl(conn);
        try {
            conn.setAutoCommit(false);
            Account fromAccount = dao.findAccountByName(fromName);
            Account toAccount = dao.findAccountByName(toName);
            fromAccount.setMoney(fromAccount.getMoney()-money);
            toAccount.setMoney(toAccount.getMoney()+money);
            // 更新
            dao.updateAccount(fromAccount);
            int i = 1 / 0;
            dao.updateAccount(toAccount);
            conn.commit();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
