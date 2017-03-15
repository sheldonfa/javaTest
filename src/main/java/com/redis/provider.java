package com.redis;

import redis.clients.jedis.Jedis;

import java.util.Random;
import java.util.UUID;

/**
 * @author fangxin
 * @description ${END}
 * @date 2017/2/27 0027.
 */
public class Provider implements Runnable{

    Jedis jedis = new Jedis("192.168.0.91", 6379);
    {
        jedis.auth("redis");
    }

    @Override
    public void run(){
        Random random = new Random();
        try {
            while (true) {
                UUID testid = UUID.randomUUID();
                jedis.lpush("task-queue", testid.toString());
                System.out.println("创建了一个生产者：" + testid);
                Thread.sleep(random.nextInt(1000) + 1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
