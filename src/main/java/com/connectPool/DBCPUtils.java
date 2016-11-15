package com.connectPool;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by Administrator on 2016/11/15.
 */
public class DBCPUtils {

    private static DataSource ds = null;

    static{
        Properties prop = new Properties();
        try {
            // 加载配置文件路径
            prop.load(DBCPUtils.class.getClassLoader().getResourceAsStream("com/connectPool/dbcpconfig.properties"));
            ds = BasicDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new ExceptionInInitializerError("initial fail");
        }
    }

    public static void release(ResultSet rs, Statement stmt, Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if(stmt!=null){
            try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if(conn!=null){
            try {
                // 可以关，原理请参考test3
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }
}
