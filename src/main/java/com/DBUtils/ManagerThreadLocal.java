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
            // startTransaction中是第一次获取conn，会走数据源获取conn，后面都不回再走这里了
            conn = C3P0Utils.getConnection();
            // 将获取到的conn放到当前线程的局部变量中，方便后面使用
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
