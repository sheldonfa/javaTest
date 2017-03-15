package com.redis;

/**
 * @author fangxin
 * @description ${END}
 * @date 2017/2/27 0027.
 */
public class Client {

    public static void main(String[] args) throws InterruptedException {
        // 启动一个生产者线程
        Thread producer = new Thread(new Provider());
        producer.start();

        Thread.sleep(500);

        // 启动一个消费者线程
        Thread consumer = new Thread(new Consumer());
        consumer.start();

        //主线程休眠
        Thread.sleep(Long.MAX_VALUE);
    }

}
