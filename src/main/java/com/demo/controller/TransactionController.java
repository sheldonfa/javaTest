package com.demo.controller;

import com.demo.pojo.User;
import com.demo.service.TransactionService;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Created by Administrator on 2016/5/15.
 */

@Controller
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping("/index")
    public String transfer(){
        return "transfer";
    }

    @RequestMapping("/transfer")
    @ResponseBody
    public String transfer(Integer fromId,Integer toId, Double cash){
        transactionService.transfer(fromId,toId,cash);
        return "yes";
    }
}

