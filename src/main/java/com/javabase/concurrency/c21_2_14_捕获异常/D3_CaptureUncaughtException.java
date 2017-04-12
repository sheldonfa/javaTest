package com.javabase.concurrency.c21_2_14_捕获异常;

import java.util.concurrent.*;

/*抛出异常的线程*/
class ExceptionThread2 implements Runnable {
  public void run() {
    Thread t = Thread.currentThread();
    System.out.println("run() by " + t);
    System.out.println(
      "eh = " + t.getUncaughtExceptionHandler());
    throw new RuntimeException();
  }
}

/**
 * step1:
 * Thread.UncaughtExceptionHandler是SE5接口，它允许你在每个线程对象上附加一个异常处理器
 * 该类会在线程因为未捕获的异常而濒临死亡的时候被调用
 */
class MyUncaughtExceptionHandler implements
Thread.UncaughtExceptionHandler {
  public void uncaughtException(Thread t, Throwable e) {
    System.out.println("caught " + e);
  }
}

/**
 * step2:
 * 为了使用“未捕获异常助手”类，我们新创建一个线程工厂，该工厂将每个新建的线程对象上附加一个“未捕获异常助手”。
 *
 */
class HandlerThreadFactory implements ThreadFactory {
  public Thread newThread(Runnable r) {
    System.out.println(this + " creating new Thread");
    Thread t = new Thread(r);
    System.out.println("created " + t);
    t.setUncaughtExceptionHandler(
      new MyUncaughtExceptionHandler());
    System.out.println(
      "eh = " + t.getUncaughtExceptionHandler());
    return t;
  }
}

public class D3_CaptureUncaughtException {
  public static void main(String[] args) {
    ExecutorService exec = Executors.newCachedThreadPool(
            /**
             * step3:
             * 将新创建的“线程工厂”传递给Executors
             */
      new HandlerThreadFactory());
    exec.execute(new ExceptionThread2());
  }
} /* Output: (90% match)
HandlerThreadFactory@de6ced creating new Thread
created Thread[Thread-0,5,main]
eh = MyUncaughtExceptionHandler@1fb8ee3
run() by Thread[Thread-0,5,main]
eh = MyUncaughtExceptionHandler@1fb8ee3
caught java.lang.RuntimeException
*///:~
