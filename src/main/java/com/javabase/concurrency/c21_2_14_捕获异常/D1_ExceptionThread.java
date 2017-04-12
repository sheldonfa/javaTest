package com.javabase.concurrency.c21_2_14_捕获异常;//: concurrency/ExceptionThread.java
// {ThrowsException}
import java.util.concurrent.*;

/**
 * 抛到run方法外部的异常
 */
public class D1_ExceptionThread implements Runnable {
  public void run() {
    throw new RuntimeException();
  }
  public static void main(String[] args) {
    ExecutorService exec = Executors.newCachedThreadPool();
    exec.execute(new D1_ExceptionThread());
  }
} ///:~
