package com.demo.service;

import com.demo.pojo.User;

/**
 * Created by Administrator on 2016/7/31.
 */
public interface UserService {

    User findUserById(Integer id);

    void updateCash(Integer userId, Double cash, String op);
}
