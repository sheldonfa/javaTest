package com.connectPool;


import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/11/13.
 */
public class Client {

    /**
     * 没有使用数据源
     */
    @Test
    public void testNoDataSource(){
        Connection conn = null;
        PreparedStatement st  = null;
        ResultSet rs    = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "select * from user where id = ?";
            st = conn.prepareStatement(sql);
            // 如果？是string类型 用setString
            st.setInt(1,1);
            // executeQuery方法中不再需要sql参数
            rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getObject(1));
                System.out.println(rs.getObject(2));
                System.out.println(rs.getObject(3));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            // 本质上是分别调用rs.close st.close 和 conn.close
            DBUtils.closeAll(rs,st,conn);
        }
    }

    /**
     * 使用自己的数据源，没有实现dataSource接口
     */
    @Test
    public void testSimpleConnectionPool() {
        Pool1SimpleConnectionPool pool = new Pool1SimpleConnectionPool();
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            // 从数据源中获取连接
            conn = pool.getConnectionFromPool();
            String sql = "select * from user where id = ?";
            st = conn.prepareStatement(sql);
            // 如果？是string类型 用setString
            st.setInt(1, 1);
            // executeQuery方法中不再需要sql参数
            rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getObject(1));
                System.out.println(rs.getObject(2));
                System.out.println(rs.getObject(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(rs!=null){
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                rs=null;
            }
            if(st!=null){
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                st=null;
            }
            // 数据源提供放回连接的方法
            pool.release(conn);
        }
    }

    /**
     * 使用实现dataSource接口的数据源 （采用）
     * 装饰模式： 注意，装饰的是Connection，然后改写close()方法
     *           以MyDataSource作为客户端，在getConnection()中实施装饰
     *           这样，依然保持原来的编程方式关闭数据源conn.close()，但是其实已经是还回连接池而不是关闭数据源
     */
    @Test
    public void testMyDataSource() {
        DataSource ds = new Pool2MyDataSource();
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            // 从数据源中获取连接，但是已经装饰了
            conn = ds.getConnection();
            String sql = "select * from user where id = ?";
            st = conn.prepareStatement(sql);
            // 如果？是string类型 用setString
            st.setInt(1, 1);
            // executeQuery方法中不再需要sql参数
            rs = st.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getObject(1));
                System.out.println(rs.getObject(2));
                System.out.println(rs.getObject(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(rs!=null){
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                rs=null;
            }
            if(st!=null){
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                st=null;
            }
            // 这里依然关闭conn，但是conn.close()已经被包装了
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                conn = null;
            }

        }
    }
}
