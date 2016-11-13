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
 * 数据库连接池减少了创建数据库连接的操作
 */
public class pool2MyDataSource implements DataSource{
    //创建一个存放连接的池子
    private static LinkedList<Connection> pool = (LinkedList<Connection>) Collections.synchronizedList(new LinkedList<Connection>());

    static{
        try {
            for (int i = 0; i < 10; i++) {
                Connection conn = DBUtils.getConnection();
                pool.add(conn);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化数据库连接失败，请检查配置文件是否正确！");
        }
    }

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        if(pool.size()>0){
            conn =  pool.removeFirst();//从池中取出一个连接
            return conn;
        }else{
            //等待
            //新创建一个连接
            throw new RuntimeException("服务器忙。。。");
        }
    }


    public Connection getConnection(String username, String password)
            throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }



    public PrintWriter getLogWriter() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    public void setLogWriter(PrintWriter out) throws SQLException {
        // TODO Auto-generated method stub

    }

    public void setLoginTimeout(int seconds) throws SQLException {
        // TODO Auto-generated method stub

    }

    public int getLoginTimeout() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }





}
