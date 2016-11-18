package com.mail;

import org.junit.Test;

/**
 * Created by Administrator on 2016/11/19.
 */
public class Client {

    @Test
    public void testSendMail(){
        SendJMail.sendMail("727171280@qq.com","hellow mail");
        System.out.println("发送成功");
    }
}
