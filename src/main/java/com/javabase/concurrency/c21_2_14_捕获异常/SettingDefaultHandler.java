package com.javabase.concurrency.c21_2_14_捕获异常;//: concurrency/SettingDefaultHandler.java

import java.util.concurrent.*;

public class SettingDefaultHandler {
  public static void main(String[] args) {
    Thread.setDefaultUncaughtExceptionHandler(
      new MyUncaughtExceptionHandler());
    ExecutorService exec = Executors.newCachedThreadPool();
    exec.execute(new D1_ExceptionThread());
  }
} /* Output:
caught java.lang.RuntimeException
*///:~
