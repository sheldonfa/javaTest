package com.designPattern.decorator.pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Administrator on 2016/11/13.
 * 数据库连接池的关闭功能 就是用装饰模式实现的
 */
public class Client {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs =null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("select * from user where id = ?");
            ps.setInt(1,1);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getObject(1));
                System.out.println(rs.getObject(2));
                System.out.println(rs.getObject(3));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            com.jdbc.DBUtils.closeAll(rs,ps,conn);
        }
    }
}
