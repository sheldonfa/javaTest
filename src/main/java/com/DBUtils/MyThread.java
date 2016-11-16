package com.DBUtils;

/**
 * Created by Administrator on 2016/11/16 0016.
 */
public class MyThread extends Thread {

    ThreadLocal tl;

    public MyThread(ThreadLocal tl) {
        this.tl = tl;
    }

    @Override
    public void run(){
        System.out.println(tl.get()); // null，其他线程，既是把主线程的tl传过来，也获取不到任何数据
    }
}
