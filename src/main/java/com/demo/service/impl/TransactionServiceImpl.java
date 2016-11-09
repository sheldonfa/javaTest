package com.demo.service.impl;

import com.demo.pojo.User;
import com.demo.service.TransactionService;
import com.demo.service.UserService;
import org.apache.ibatis.transaction.managed.ManagedTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/11/9.
 */
@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    public UserService userService;

    @Override
    public boolean transfer(Integer fromId,Integer toId,Double cash) {

        System.out.println("aa");
        userService.updateCash(fromId,cash,"sub");
//        int i = 1 / 0;
        userService.updateCash(toId,cash,"plus");
        return true;
    }
}
