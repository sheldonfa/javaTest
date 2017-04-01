package com.mybatis.test;

import com.demo.pojo.User;
import com.mybatis.mapper.Test2Mapper;
import com.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/30.
 */
public class Test2 {

    SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        String resource = "com/mybatis/cofig/SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    @After
    public void close(){
//        sqlSession.close();
    }

    /**
     * parameterMap使用
     *
     * 这什么狗屁标签，用@Param多好
     */
    @Test
    public void test1() throws Exception{
//        Map<String,String>  map = new HashMap<String,String>();
//        map.put("id","1");
//        Test2Mapper mapper = sqlSession.getMapper(Test2Mapper.class);
//        User user = mapper.testParameterMap(map);
    }

    /**
     * trim标签使用
     * 1、trim 有四个属性 prefix，prefixOverrides，suffix，suffixOverrides
     * 2、prefix，suffix的意思是，在前面修改，在后面修改。在trim标签包裹的部分的前面或者后面添加内容（没有prefixOverrides，suffixOverrides的情况下）
     * 3、如果有prefixOverrides，suffixOverrides 表示覆盖Overrides中的内容
     * 4、如果只有prefixOverrides，suffixOverrides，表示删除。
     */
    @Test
    public void test2(){
        Test2Mapper mapper = sqlSession.getMapper(Test2Mapper.class);
        User user = new User();
        user.setId(1);
        user.setCash(11d);
        mapper.testTrim(user);
        sqlSession.commit();
    }

    /**
     * choose when otherwise
     * where 标签自动去除多余的and
     * set 标签自动去除多余的逗号
     * 与 if标签相比，只会执行一个，并且写在前面的when标签优先匹配
     */
    @Test
    public void test3(){
        Test2Mapper mapper = sqlSession.getMapper(Test2Mapper.class);
        User user = new User();
//        user.setId(3);
//        user.setAddress("aa");
        List<User> users = mapper.testChooseWhen(user);
        System.out.println(users);
    }


}
