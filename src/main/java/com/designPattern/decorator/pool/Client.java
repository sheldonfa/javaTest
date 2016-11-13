package com.designPattern.decorator.pool;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by Administrator on 2016/11/13.
 * 数据库连接池的关闭功能 就是用装饰模式实现的
 */
public class Client {

    Connection conn = null;
    PreparedStatement ps = null;


}
