package com.connectPool;


import com.demo.pojo.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.ibatis.annotations.Result;
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
     * 1 没有使用数据源
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
            st.setInt(1,1);
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
     * 2 使用自己的数据源，没有实现dataSource接口
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
            st.setInt(1, 1);
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
            // 自定义数据源提供放回连接的方法
            pool.release(conn);
        }
    }

    /**
     * 3 使用实现dataSource接口的数据源 （采用）
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
            st.setInt(1, 1);
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
            // 保持原来的编码规范，这里依然关闭conn，但是conn.close()已经被包装了
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

    /**
     * 4 DBCP数据源
     * Apache出品
     * DBCPUtils 主要有getConnection方法和release方法
     */
    @Test
    public void testDBCP(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBCPUtils.getConnection();
            ps = conn.prepareStatement("SELECT * FROM user WHERE id=?");
            ps.setInt(1,1);
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getObject(1));
                System.out.println(rs.getObject(2));
                System.out.println(rs.getObject(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DBCPUtils.release(rs,ps,conn);
        }
    }

    /**
     * 5 C3P0数据源
     *
     * 注意：c3p0-config.xml名称固定不变
     */
    @Test
    public void testC3P0(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = C3P0Utils.getConnection();
            ps = conn.prepareStatement("SELECT * FROM user WHERE id=?");
            ps.setInt(1,1);
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getObject(1));
                System.out.println(rs.getObject(2));
                System.out.println(rs.getObject(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3P0Utils.release(rs,ps,conn);
        }
    }

    /**
     * javaWeb服务器tomcat内置数据源（C3P0）
     * 只需要配置即可
     */
    // 略
}
