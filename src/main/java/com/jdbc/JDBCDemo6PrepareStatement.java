package com.jdbc;

import java.sql.*;

/**
 * Created by Administrator on 2016/11/10 0010.
 * 创建jdbc链接
 */
public class JDBCDemo6PrepareStatement {
    public static void main(String[] args){
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
            DBUtils.closeAll(rs,st,conn);

        }
    }
}
