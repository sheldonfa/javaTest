package com.javabase.concurrency.c21_2_14;//: concurrency/NaiveExceptionHandling.java
// {ThrowsException}
import com.javabase.concurrency.c21_2_14.ExceptionThread;

import java.util.concurrent.*;

/**
 * 由于线程的本质特性，使得你不能捕获从线程中逃逸的异常
 */
public class NaiveExceptionHandling {
  public static void main(String[] args) {
    try {
      ExecutorService exec =
        Executors.newCachedThreadPool();
      exec.execute(new ExceptionThread());
    } catch(RuntimeException ue) {
      // This statement will NOT execute!
      System.out.println("Exception has been handled!");
    }
  }
} ///:~
