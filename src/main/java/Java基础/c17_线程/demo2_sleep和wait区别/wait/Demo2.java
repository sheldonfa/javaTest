package Java基础.c17_线程.demo2_sleep和wait区别.wait;

import java.util.concurrent.TimeUnit;

/**
 * t3 wait之后，让出了cpu，释放锁。t2执行完毕唤醒t3,t3运行结束
 */
public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t3 = new Thread(new T3());
        t3.start();
        TimeUnit.MILLISECONDS.sleep(1);// 保证t3先执行
        Thread t2 = new Thread(new T2());
        t2.start();
    }
}
