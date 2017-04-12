package com.javabase.concurrency.c21_3_2;//: concurrency/SynchronizedEvenGenerator.java
// Simplifying mutexes with the synchronized keyword.
// {RunByHand}

import com.javabase.concurrency.c21_3_1.EvenChecker;
import com.javabase.concurrency.c21_3_1.IntGenerator;

public class
D1_SynchronizedEvenGenerator extends IntGenerator {
  private int currentEvenValue = 0;

  /**
   * 加了锁之后就是原子性的了，不会失败了。
   */
  public synchronized int next() {
    ++currentEvenValue;
    Thread.yield(); // Cause failure faster
    ++currentEvenValue;
    return currentEvenValue;
  }
  public static void main(String[] args) {
    EvenChecker.test(new D1_SynchronizedEvenGenerator());
  }
} ///:~
