package com.designPattern.proxy;

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
        System.out.println("conn==========================="+conn+"===========thread========="+tl);
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
        System.out.println("开启事务");
    }

    public static void commit(){
        Connection conn = getConnection();
        try {
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("提交事务");
    }

    public static void rollback(){
        Connection conn = getConnection();
        try {
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("回滚事务");
    }

    public static void close(){
        try {
            getConnection().close();
            tl.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("关闭连接");
    }
}
