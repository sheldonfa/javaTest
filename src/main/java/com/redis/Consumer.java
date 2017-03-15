package com.redis;

import redis.clients.jedis.Jedis;

import java.util.Random;

/**
 * @author fangxin
 * @description ${END}
 * @date 2017/2/27 0027.
 */
public class Consumer implements Runnable{
    Jedis jedis = new Jedis("192.168.0.91", 6379);
    Random random = new Random();

    {
        jedis.auth("redis");
    }

    @Override
    public void run() {
        while (true) {
            try {
                String testId = jedis.rpoplpush("task-queue", "tmp-queue");
                int i = random.nextInt(9);
                if ((i % 5) == 0) {
                    jedis.rpoplpush("tmp-queue", "task-queue");
                    System.out.println("操作失败：" + testId);
                } else {
                    jedis.rpop("tmp-queue");
                    System.out.println("操作成功：" + testId);
                }
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
//    @Override
//    public void run() {
//        while (true) {
//            try {
//                int i = random.nextInt(9);
//                if ((i % 5) == 0) {
//                    String testId = jedis.rpoplpush("task-queue", "task-queue");
//                    System.out.println("操作失败：" + testId);
//                } else {
//                    String testId = jedis.rpop("task-queue");
//                    System.out.println("操作成功：" + testId);
//                }
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

}
