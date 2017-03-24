package com.javabase.concurrency.c21_2_14;//: concurrency/SettingDefaultHandler.java
import com.javabase.concurrency.c21_2_14.ExceptionThread;

import java.util.concurrent.*;

public class SettingDefaultHandler {
  public static void main(String[] args) {
    Thread.setDefaultUncaughtExceptionHandler(
      new MyUncaughtExceptionHandler());
    ExecutorService exec = Executors.newCachedThreadPool();
    exec.execute(new ExceptionThread());
  }
} /* Output:
caught java.lang.RuntimeException
*///:~
