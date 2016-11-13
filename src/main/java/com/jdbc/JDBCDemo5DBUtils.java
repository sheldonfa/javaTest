package com.jdbc;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2016/11/10 0010.
 * 创建数据库连接，大部分代码时重复的，所以可以提取为Utils，同理，释放资源也可以提取为工具
 */
public class JDBCDemo5DBUtils {

    public static void main(String[] args){
        Connection conn = null;
        Statement st  = null;
        ResultSet rs    = null;
        try {
            conn = getConnection();
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
            close(conn, st, rs);

        }

    }


    /**
     *
     * 以下是工具部分的内容
     */
    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;

    static{
        // 用ResourceBundel可以直接读取classes目录下的properties文件
        ResourceBundle bundle = ResourceBundle.getBundle("com.jdbc.dbinfo");
        driverClass = bundle.getString("driverClass");
        url = bundle.getString("url");
        username = bundle.getString("username");
        password = bundle.getString("password");
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 获取连接
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        return DriverManager.getConnection(url, username, password);
    }

    // 关闭连接
    private static void close(Connection conn, Statement st, ResultSet rs) {
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
