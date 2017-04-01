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
        sqlSession.close();
    }

    /**
     * parameterMap使用
     * @throws Exception
     */
    @Test
    public void test1() throws Exception{
        Map<String,String>  map = new HashMap<String,String>();
        map.put("id","1");
        Test2Mapper mapper = sqlSession.getMapper(Test2Mapper.class);
        User user = mapper.testParameterMap(map);
    }

    @Test
    public void test2(){

    }

}
