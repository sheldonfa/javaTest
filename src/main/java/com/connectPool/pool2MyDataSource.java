package com.connectPool;

import com.designPattern.decorator.pool.DBUtils;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * 实现接口规范的数据源
 */
public class Pool2MyDataSource implements DataSource{
    //创建一个存放连接的池子
    private static LinkedList<Connection> pool = new LinkedList<Connection>();

    static{
        try {
            for (int i = 0; i < 10; i++) {
                Connection conn = DBUtils.getConnection();
                pool.add(conn);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("error");
        }
    }

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        if(pool.size()>0){
            conn =  pool.removeFirst();//从池中取出一个连接
            // 对获取到的conn进行装饰，以改写close方法
            MyConnection myConn = new MyConnection(conn, pool);
            return myConn;
        }else{
            //等待
            //新创建一个连接
            throw new RuntimeException("server error");
        }
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
