package com.jdbc;

import java.sql.*;

/**
 * Created by Administrator on 2016/11/10 0010.
 * 创建jdbc链接
 */
public class JDBCDemo1DriverManager {
    public static void main(String[] args) throws SQLException {
        /**
         * DriverManager.registerDriver不建议使用
         * 1 导致驱动注册两次
         * 2 依赖数据库的驱动jar
         */
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis","root","root");
        Statement statement = conn.createStatement();
        String sql = "select * from user where id = 1";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            System.out.println(resultSet.getObject(1));
            System.out.println(resultSet.getObject(2));
            System.out.println(resultSet.getObject(3));
        }
        resultSet.close();
        statement.close();
        conn.close();
    }
}
