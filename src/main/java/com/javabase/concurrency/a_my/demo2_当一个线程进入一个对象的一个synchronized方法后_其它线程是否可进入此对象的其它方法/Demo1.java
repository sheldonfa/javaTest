package com.javabase.concurrency.a_my.demo2_当一个线程进入一个对象的一个synchronized方法后_其它线程是否可进入此对象的其它方法;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 对象锁和对象的类锁，这是两码事
 */

class Thread1 implements Runnable{
    @Override
    public void run() {
        print();
    }

    public void print(){
        /**
         * 锁用的Thread1的对象
         */
        synchronized (this){
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("thread1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Thread2 implements Runnable{

    @Override
    public void run() {
        print();
    }

    public static void print(){
        /**
         * 静态方法用的锁是Thread1的类
         */
        synchronized (Thread1.class){
            System.out.println("thread2");
        }
    }
}

public class Demo1 {

    public static void main(String[] args) {
        ExecutorService exe = Executors.newCachedThreadPool();
        /**
         * 用对象锁和用这个对象的class锁是两码事，thread1的阻塞没有挡住thread2的运行
         */
        exe.execute(new Thread1());
        exe.execute(new Thread2());
        exe.shutdown();
    }

}
