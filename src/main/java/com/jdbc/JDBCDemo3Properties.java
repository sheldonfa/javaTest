package com.jdbc;

import java.sql.*;
import java.util.Properties;

/**
 * 通过Properties对象将DriverManager.getConnection的用户名、密码提取出来
 */
public class JDBCDemo3Properties {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        // 创建Properties对象
        Properties info = new Properties();
        // 塞入用户名和密码  ?为什么用户名是user而不是username，这是因为mysql连接手册中已经明确规定了，属于规范
        info.setProperty("user","root");
        info.setProperty("password","root");
        // 也可以Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?user=root&password=root");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis",info);
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
