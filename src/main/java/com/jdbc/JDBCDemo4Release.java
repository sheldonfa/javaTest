package com.jdbc;

import java.sql.*;

/**
 * Created by Administrator on 2016/11/10 0010.
 * 创建jdbc连接，释放资源很重要
 */
public class JDBCDemo4Release {
    public static void main(String[] args){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis", "root", "root");
            st = conn.createStatement();
            String sql = "select * from user where id = 1";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getObject(1));
                System.out.println(rs.getObject(2));
                System.out.println(rs.getObject(3));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            // 关闭资源
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                // 垃圾回收
                rs = null;
            }
            if(st!=null){
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                rs = null;
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                rs = null;
            }
        }

    }
}
