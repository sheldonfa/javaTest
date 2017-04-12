package com.javabase.concurrency.c21_2_14_捕获异常;//: concurrency/NaiveExceptionHandling.java
// {ThrowsException}

import java.util.concurrent.*;

/**
 * 由于线程的本质特性，使得你不能捕获从线程中逃逸的异常
 */
public class D2_NaiveExceptionHandling {
  public static void main(String[] args) {
    /**
     * try catch根本捕获不到
     */
    try {
      ExecutorService exec =
        Executors.newCachedThreadPool();
      exec.execute(new D1_ExceptionThread());
    } catch(RuntimeException ue) {
      // This statement will NOT execute!
      System.out.println("Exception has been handled!");
    }
  }
} ///:~
