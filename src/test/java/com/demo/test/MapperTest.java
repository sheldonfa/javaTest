package com.demo.test;


import com.demo.pojo.User;
import com.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by Administrator on 2016/7/30.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml"})
public class MapperTest {

    @Autowired
    private UserService userService;

//    @Test
//    public void testFindUserByUserVo() throws Exception {
//        User user = userService.findUserById(1);
//        System.out.println(user);
//        Thread thread = new Thread();
//        String doc = "doctor";
//        switch (doc) {
//            case "doctor":
//                break;
//            default:
//                break;
//        }
//    }

//    @Test
//    public void test1(){
//        byte a =1;
//        byte b =2;
//        byte c;
//        c = (byte) (a+b);
//    }

}