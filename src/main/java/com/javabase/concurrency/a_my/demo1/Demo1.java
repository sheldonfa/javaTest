package com.javabase.concurrency.a_my.demo1;

/**
 * sleep与wait区别
 *
 * sleep 就是正在执行的线程主动让出 cpu， cpu 去执行其他线程，在 sleep 指定的时间过后，
 * cpu 才会回到这个线程上继续往下执行，如果当前线程进入了同步锁， sleep 方法并不会释
 * 放锁，即使当前线程使用 sleep 方法让出了 cpu，但其他被同步锁挡住了的线程也无法得到
 * 执行。 wait 是指在一个已经进入了同步锁的线程内，让自己暂时让出同步锁，以便其他正在
 * 等待此锁的线程可以得到同步锁并运行，只有其他线程调用了 notify 方法（ notify 并不释放
 * 锁，只是告诉调用过 wait 方法的线程可以去参与获得锁的竞争了，但不是马上得到锁，因
 * 为锁还在别人手里，别人还没释放。如果 notify 方法后面的代码还有很多，需要这些代码执
 * 行完后才会释放锁，可以在 notfiy 方法后增加一个等待和一些代码，看看效果），调用 wait
 * 方法的线程就会解除 wait 状态和程序可以再次得到锁后继续向下运行。对于 wait 的讲解一
 * 定要配合例子代码来说明，才显得自己真明白。
 */
public class Demo1 {
    private static class Thread1 implements Runnable {
        @Override
        public void run() {
            /**
             * 由于这里的 Thread1和下面的 Thread2内部 run 方法要用同一对象作为监视器，我们这里
             * 不能用 this，因为在 Thread2里面的 this 和这个 Thread1的 this 不是同一个对象。我们用
             * MultiThread.class 这个字节码对象，当前虚拟机里引用这个变量时，指向的都是同一个对象。
             */
            synchronized (Demo1.class) {
                System.out.println("enter thread1...");
                System.out.println("thread1 is waiting");
                try {
                    /**
                     * 释放锁有两种方式，第一种方式是程序自然离开监视器的范围，也就是离开
                     * 了 synchronized 关键字管辖的代码范围，另一种方式就是在 synchronized 关键字管辖的代
                     * 码内部调用监视器对象的 wait 方法。这里，使用 wait 方法释放锁。
                     */
                    Demo1.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread1 is going on...");
                System.out.println("thread1 is being over!");
            }
        }
    }

    private static class Thread2 implements Runnable{
        @Override
        public void run () {
            synchronized (Demo1.class) {
                System.out.println("enter thread2...");
                System.out.println("thread2 notify other thread can release wait status..");
                /**
                 * 由于 notify 方法并不释放锁，即使 thread2调用下面的 sleep 方法休息了10毫秒，但 thread1
                 * 仍然不会执行，因为 thread2没有释放锁，所以 Thread1无法得不到锁。
                 * MultiThread.class.notify();
                 */
                System.out.println("thread2 is sleeping ten millisecond...");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 is going on...");
                System.out.println("thread2 is being over!");
            }
        }
    }

    /**
     * 先启动thread1，由于thread1是wait，所以执行thread2，并且thread2先结束
     */
//    public static void main(String[] args) {
//        new Thread(new Thread1()).start();
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        new Thread(new Thread2()).start();
//    }

    /**
     * 先启动thread2，由于thread2是sleep，所以thread1进不来，等thread2执行完毕，thread1执行
     */
    public static void main(String[] args) {
        new Thread(new Thread2()).start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Thread1()).start();
    }
}
