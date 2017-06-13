package Java基础.c17_线程.demo3_volatile的可见性;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 *
 * 通过实例了解 可见性
 */
public class VolatileDemo implements Runnable {

    /**volatile*/
    private volatile boolean isRunning = true;

    @Override
    public void run() {
        while (isRunning){
            // 空循环
        }
        System.out.println("线程停止");
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileDemo demo = new VolatileDemo();
        Thread t1 = new Thread(demo);
        System.out.println("开启线程");
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("设置停止运行");
        /**
         * 由于主内存拷贝原理，这里只是修改了主内存中的isRunning，线程工作区中的isRunning还是true
         * 解决办法，是isRunning添加volatile
         *
         * 怎么确定主线程停止了？如果用@Test测试，可以确定是t1没有结束，主线程之所以没有结束，是因为t1没有结束
         */
        demo.setRunning(false);
        System.out.println("isRunning:"+demo.isRunning);
        TimeUnit.SECONDS.sleep(1);
    }
}
