package com.thread.page1;

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
}
