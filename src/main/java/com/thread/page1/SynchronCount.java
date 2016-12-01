package com.thread.page1;

/**
 * Created by Administrator on 2016/11/27.
 */
public class SynchronCount implements Runnable{

    private long count;

    public long getCount() {
        return count;
    }

    public synchronized void executeCount(){
        count++;
        System.out.println(getCount());
    }

    @Override
    public void run() {
        executeCount();
    }
}
