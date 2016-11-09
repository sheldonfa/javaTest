package com.demo.mapper;

import com.demo.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2016/7/30.
 */
public interface UserMapper {

    User findUserById(Integer id);

    void updateCash(@Param("userId")Integer userId, @Param("cash") Double cash, @Param("op")String op);
}
