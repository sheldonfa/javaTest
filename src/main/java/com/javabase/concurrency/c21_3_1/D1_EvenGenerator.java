package com.javabase.concurrency.c21_3_1;//: concurrency/EvenGenerator.java
// When threads collide.

public class D1_EvenGenerator extends IntGenerator {
  private int currentEvenValue = 0;

  public int next() {
    /**
     * next非原子性，所以这里不是每次都是返回偶数的
     */
    ++currentEvenValue; // Danger point here!
    ++currentEvenValue;
    return currentEvenValue;
  }

  /**
   * 任务目的：检测多个线程操作currentEvenValue。在next方法中间横插一脚。
   */
  public static void main(String[] args) {
    EvenChecker.test(new D1_EvenGenerator());
  }
} /* Output: (Sample)
Press Control-C to exit
89476993 not even!
89476993 not even!
*///:~
