package com.thread.c2;

/**
 * Created by Administrator on 2016/11/27.
 */
public class Count implements Runnable{

    private long count;

    public long getCount() {
        return count;
    }

    public void executeCount(){
        count++;
        System.out.println(getCount());
    }

    @Override
    public void run() {
        executeCount();
    }
}
