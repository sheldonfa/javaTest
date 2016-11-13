package com.jdbc;

import java.sql.*;

/**
 * Created by Administrator on 2016/11/10 0010.
 * 创建jdbc链接
 */
public class JDBCDemo2ClassForName {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        /**
         * Class.forName("com.mysql.jdbc.Driver");的方式注册驱动
         */
        Class.forName("com.mysql.jdbc.Driver");
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
