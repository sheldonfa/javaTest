package com.DBUtils;

import com.connectPool.C3P0Utils;
import com.demo.pojo.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/16 0016.
 * DBUtils使用
 * Apache出品
 */
public class Client1 {

    /**
     * 增删改、批处理
     */
    @Test
    public void testDBUtilsOfApacheInsert() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        //自增主键可以用null代替
        qr.update("insert into user values(null,?,?) ","lisi",1000);
    }
    @Test
    public void testDBUtilsOfApacheUpdate() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        qr.update("update user set name=?,cash=? where id=?","zhangsan",1500,1);
    }
    @Test
    public void testDBUtilsOfApacheDelete() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        qr.update("delete from user where id=?",3);
    }
    @Test
    public void testDBUtilsOfApacheBatch() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        Object[][] params = new Object[10][];
        for(int i=0;i<params.length;i++){
            params[i] = new Object[]{"wangwu"+i,1500+i};
        }
        qr.batch("insert into user(name,cash) values(?,?)",params);
    }
    /**
     * 查
     */
    @Test//ArrayHandler:适合取1条记录。把该条记录的每列值封装到一个数组中Object[]  如果有多条记录，只取第一条
    public void testQuery1() throws SQLException{
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        Object[] arr  = qr.query("select * from user where id=?", new ArrayHandler(),1);
        for (Object o : arr) {
            System.out.println(o);
        }
    }
    @Test//ArrayListHandler:适合取多条记录。把每条记录的每列值封装到一个数组中Object[]，把数组封装到一个List中
    public void testQuery2() throws SQLException{
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        List<Object[]> query = qr.query("select * from user", new ArrayListHandler());
        for (Object[] os : query) {
            for (Object o : os) {
                System.out.println(o);
            }
            System.out.println("--------------");
        }
    }
    @Test //ColumnListHandler:取某一列的数据。封装到List中。
    public void testQuery3() throws SQLException{
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        List<Object> list = (List<Object>) qr.query("select name,cash from user", new ColumnListHandler(2));
        for (Object o : list) {
            System.out.println(o);
        }
    }
    @Test //KeyedHandler:取多条记录，每一条记录封装到一个Map中，再把这个Map封装到另外一个Map中，key为指定的字段值。
    public void testQuery4() throws SQLException{
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        //大Map的key是表中的某列数据，小Map中的key是表的列名，所以大Map的key是Object类型，小Map的key是String类型
        Map<Object,Map<String,Object>> map = (Map<Object, Map<String, Object>>) qr.query("select * from user", new KeyedHandler(1));

        for (Map.Entry<Object, Map<String,Object>> m : map.entrySet()) {
            System.out.println(m.getKey());//大Map中key值就是id列的值
            for (Map.Entry<String, Object> mm : m.getValue().entrySet()) {
                System.out.println(mm.getKey()+"\t"+mm.getValue());//取出小Map中的列名和列值
            }
            System.out.println("---------------------");
        }
    }
    @Test//MapHandler:适合取1条记录。把当前记录的列名和列值放到一个Map中
    public void testQuery5() throws SQLException{
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        Map<String,Object> map = qr.query("select * from user where id=?", new MapHandler(),1);

        for (Map.Entry<String, Object> m : map.entrySet()) {
            System.out.println(m.getKey()+"\t"+m.getValue());
        }

    }
    @Test//MapListHandler:适合取多条记录。把每条记录封装到一个Map中，再把Map封装到List中
    public void testQuery6() throws SQLException{
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        List<Map<String,Object>> list = qr.query("select * from user", new MapListHandler());

        for (Map<String, Object> map : list) {
            for (Map.Entry<String, Object> m : map.entrySet()) {
                System.out.println(m.getKey()+"\t"+m.getValue());
            }
            System.out.println("---------------");
        }
    }
    @Test //ScalarHandler:适合取单行单列数据
    public void testQuery7() throws SQLException{
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        Object o = qr.query("select count(*) from user", new ScalarHandler(1));
        System.out.println(o.getClass().getName());
    }
    @Test //☆BeanHandler:适合取单行单列数据
    public void testQuery8() throws SQLException{
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        User user = qr.query("select * from user where id=?", new BeanHandler<User>(User.class),1);
        System.out.println(user);
    }
    @Test //☆☆☆☆☆BeanListHandler
    public void testQuery9() throws SQLException{
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        List<User> list = qr.query("select * from user", new BeanListHandler<User>(User.class));

        System.out.println(list.size());
    }
    @Test // 将查询的结果自定义操作
    public void testResultSetHandler() throws SQLException{
        //创建一个QueryRunner对象
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        List<User> list = qr.query("select * from user", new ResultSetHandler<List<User>>(){
            //当query方法执行select语句后，将结果集以参数的形式传递过来
            public List<User> handle(ResultSet rs) throws SQLException {
                List<User> list  = new ArrayList<User>();
                while(rs.next()){
                    User u = new User();
                    u.setId(rs.getInt(1));
//                    u.setUsername(rs.getString(2));
                    u.setCash(rs.getDouble(3));
                    list.add(u);
                }
                return list;
            }

        });
        for (User user : list) {
            System.out.println(user);
        }
    }
}
