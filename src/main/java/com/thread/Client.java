package com.thread;

import com.thread.page1.AutomicCount;
import com.thread.page1.Count;
import com.thread.page1.SynchronCount;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 注意：test方法不是main方法，当test方法执行结束，其他线程会立即停止，所以这里必须sleep，而且sleep时间要够运行的
 * 注意：test方法不是main方法，当test方法执行结束，其他线程会立即停止，所以这里必须sleep，而且sleep时间要够运行的
 * 注意：test方法不是main方法，当test方法执行结束，其他线程会立即停止，所以这里必须sleep，而且sleep时间要够运行的
 */
public class Client {

    /**
     * 竞态条件：是指设备或系统出现不恰当的执行时序，而得到不正确的结果。
     *         当某个计算的正确性取决于多个线程的交替执行时序时，就会发生静态条件
     * 特点：先检查后执行
     * 案例：如延迟初始化
     * @from java并发编程实战p16
     */
    @Test
    public void test1() throws InterruptedException {
        Count count = new Count();
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

    /**
     * AutomicLong是线程安全的long类型
     * 不会出现竞态条件现象
     * 但是：打印顺序经常不是固定的，因为计算+打印并不是一个原子操作
     */
    @Test
    public void test2() throws InterruptedException {
        AutomicCount count = new AutomicCount();
        List<Thread> threadList = new ArrayList<Thread>();
        for(int i=0;i<500;i++){
            Thread ti = new Thread(count);
            threadList.add(ti);
        }
        for(Thread t: threadList){
            t.start();
        }
        Thread.sleep(2000);
    }

    /**
     * 通过锁的机制解决：计算+打印成为一个原子操作
     */
    @Test
    public void test3() throws InterruptedException {
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
}
