package com.demo.mapper;

import com.demo.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/30.
 */
public interface UserMapper {

    User findUserById(Integer id);

    void updateCash(@Param("userId")Integer userId, @Param("cash") Double cash, @Param("op")String op);

    List<User> testObj1();


    List<Map<String,Object>> testMap1();

    Map<String,User> testMap2();
}
