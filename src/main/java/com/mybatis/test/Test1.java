package com.mybatis.test;

import com.mybatis.mapper.UserMapper;
import com.demo.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * Created by Administrator on 2016/7/30.
 */
public class Test1 {

    @Before
    public void init(){
        // 配置文件
        String resource = "SqlMapConfig.xml";
    }

    @Test
    public void findUserByIdTest() throws Exception{

        //1、读取配置文件
        String resource = "com/mybatis/cofig/SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //3、SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        /**
         * 4a、SqlSession执行statement，并返回映射结果
         *
         * 参数1：statement的id
         * 参数2：入参
         * 注意：此时映射文件的namespace不重要，config.xml中是否配置了映射文件很重要
         */
//        User user = sqlSession.selectOne("findUserById", 1);
        /**
         * 4b、通过mapper更能看到本质
         * 注意：此时映射文件的namespace很重要，config.xml中是否配置了映射文件也重要
         */
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserById(1);
        /**
         * 由此可见，最保险的做法，就是namespace不要自定义，就用接口的全限定名称
         */


        //打印输出结果集
        System.out.println(user);

        //5、关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void test2(){

    }

}
