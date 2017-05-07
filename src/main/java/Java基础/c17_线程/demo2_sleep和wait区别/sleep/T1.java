package Java基础.c17_线程.demo2_sleep和wait区别.sleep;

import java.util.concurrent.TimeUnit;

class T1 implements Runnable{

    @Override
    public void run() {
        synchronized (Demo1.class){
            System.out.println("thread 1 启动");
            try {
                System.out.println("thread 1 sleep");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("5秒钟过去了");
                System.out.println("thread 1 结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
