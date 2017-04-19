package com.javabase.concurrency.a_my.demo3_线程设计;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 设计 4 个线程，其中两个线程每次对 j 增加 1，另外两个线程对 j 每次减少 1
 */
public class Demo1 {

    static long j = 0;

    static class Thread1 implements Runnable{
        @Override
        public void run() {
            while (true){
                System.out.println(addJ());
            }
        }

        private long addJ(){
            j++;
            return j;
        }
    }

    static class Thread2 implements Runnable{
        @Override
        public void run() {
            while(true){
                System.out.println(addJ());
            }
        }

        private long addJ(){
            j++;
            return j;
        }
    }

    static class Thread3 implements Runnable{
        @Override
        public void run() {
            while(true){
                System.out.println(subJ());
            }
        }

        private long subJ(){
            j--;
            return j;
        }
    }

    static class Thread4 implements Runnable{
        @Override
        public void run() {
            while(true){
                System.out.println(subJ());
            }
        }

        private long subJ(){
            j--;
            return j;
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Thread1());
        executorService.execute(new Thread2());
        executorService.execute(new Thread3());
        executorService.execute(new Thread4());
    }
}
