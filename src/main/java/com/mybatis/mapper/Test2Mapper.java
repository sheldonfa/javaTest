package com.mybatis.mapper;

import com.demo.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface Test2Mapper {


    User testParameterMap(Map map);

    void testTrim(User user);

    List<User> testChooseWhen(User user);

}
