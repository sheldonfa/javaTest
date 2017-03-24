package com.javabase.concurrency.daemon;

import java.util.concurrent.TimeUnit;

/**
 * 后台线程
 * @author fangxin
 * @description ${END}
 * @date 2017/3/24 0024.
 */
public class SimpleDaemons implements Runnable{

    @Override
    public void run() {
        try{
            while(true){
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread()+" "+this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<10;i++){
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true); // must call before start()
            daemon.start();
        }
        System.out.println("ALL deamons started");
        TimeUnit.MILLISECONDS.sleep(575);
    }
}
