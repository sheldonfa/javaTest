package com.javabase.concurrency.a_my.demo3_线程设计;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 子线程循环 10 次，接着主线程循环 100，接着又回到子线程循环 10 次，接着再回到主线程又循环 100，如此循环 50 次，请写出程序。
 */

class Count{
    private static int count = 0;
    public static synchronized int getCount(){
        return count;
    }
    public static synchronized void add(){
        count++;
    }

    private void print(){
        notifyAll();
        for(int i=0;i<10;i++){
            System.out.println("sub");
        }
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SubThread implements Runnable{

    private Count count;

    public SubThread(Count count) {
        this.count = count;
    }

    @Override
    public void run() {

    }

}

class SupThread implements Runnable{
    private Count count;

    public SupThread(Count count) {
        this.count = count;
    }

    @Override
    public void run() {

    }
}

public class Demo2 implements Runnable{

    int count = 0;

    @Override
    public void run() {
        print();
    }

    private void print(){
        synchronized (this){
            notifyAll();
            if(count==50){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
//            for(int i=0;i<100;i++){
//                System.out.println("main");
//            }
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            count++;
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Demo2());
//        executorService.execute(new SubThread());
    }
}
