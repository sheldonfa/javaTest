package com.demo.service;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/11/9.
 */
public interface TransactionService {

    boolean transfer(Integer fromId,Integer toId,Double cash);
}
