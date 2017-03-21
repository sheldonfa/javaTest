package com.thread.c2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Administrator on 2016/11/27.
 */
public class AutomicCount implements Runnable{

    private AtomicLong count = new AtomicLong(0);

    public void executeCount(){
        long l = count.incrementAndGet();
        System.out.println(l);
    }

    @Override
    public void run() {
        executeCount();
    }

    public void threadUnSafe(){
        Count count = new Count();
        List<Thread> threadList = new ArrayList<Thread>();
        for(int i=0;i<1000;i++){
            Thread ti = new Thread(count);
            threadList.add(ti);
        }
        for(Thread t: threadList){
            t.start();
        }
    }

    public void threadSafe() throws InterruptedException {
        AutomicCount count = new AutomicCount();
        List<Thread> threadList = new ArrayList<Thread>();
        for(int i=0;i<1000;i++){
            Thread ti = new Thread(count);
            threadList.add(ti);
        }
        for(Thread t: threadList){
            t.start();
        }
        Thread.sleep(2000);
    }

    public void withSyn() throws InterruptedException {
        SynchronCount count = new SynchronCount();
        List<Thread> threadList = new ArrayList<Thread>();
        for(int i=0;i<500;i++){
            Thread ti = new Thread(count);
            threadList.add(ti);
        }
        for(Thread t: threadList){
            t.start();
        }
        Thread.sleep(1000);
    }

    public static void main(String[] args) throws InterruptedException {
        AutomicCount a = new AutomicCount();
        /**
         * 竞态条件：是指设备或系统出现不恰当的执行时序，而得到不正确的结果。
         *         当某个计算的正确性取决于多个线程的交替执行时序时，就会发生静态条件
         * 特点：先检查后执行
         * 案例：如延迟初始化
         * @from java并发编程实战p16
         */
//        a.threadUnSafe();
        /**
         * AutomicLong是线程安全的long类型
         * 不会出现竞态条件现象
         * 但是：打印顺序经常不是固定的，因为计算+打印并不是一个原子操作
         */
//        a.threadSafe();
        /**
         * 通过锁的机制解决：计算+打印成为一个原子操作
         */
        a.withSyn();
    }

}
