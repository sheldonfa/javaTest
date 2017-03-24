package com.javabase.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用Executor，取代new Thread(runnable)的方式。
 * @author fangxin
 * @description ${END}
 * @date 2017/3/23 0023.
 */
public class T1 {

    public static void main(String[] args) {
        ExecutorService ex = Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            ex.execute(new LiftOff());
        }
    }
}
