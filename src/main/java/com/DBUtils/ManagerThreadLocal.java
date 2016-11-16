package com.DBUtils;

import com.connectPool.C3P0Utils;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/11/16 0016.
 */
public class ManagerThreadLocal {
    
    public static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    
    public static Connection getConnection(){
        Connection conn = tl.get();
        if(conn==null){
            conn = C3P0Utils.getConnection();
            tl.set(conn);
        }
        return conn;
    }

    public static void startTransaction(){
        Connection conn = getConnection();
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void commit(){
        Connection conn = getConnection();
        try {
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollback(){
        Connection conn = getConnection();
        try {
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(){
        try {
            getConnection().close();
            tl.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
