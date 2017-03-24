package com.javabase.concurrency.daemon;

import java.util.concurrent.ThreadFactory;

/**
 * @author fangxin
 * @description ${END}
 * @date 2017/3/24 0024.
 */
public class DaemonThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
