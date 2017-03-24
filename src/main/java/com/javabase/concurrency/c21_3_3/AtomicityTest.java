package com.javabase.concurrency.c21_3_3;//: concurrency/AtomicityTest.java
import java.util.concurrent.*;

/**
 * getValue方法中，尽管return i是原子操作，但是缺少同步，可以在i的中间状态被读取
 *
 * Brian的同步规则:
 * 如果你正在写一个变量，他可能接下来将被另一个线程读取，或者正在读取一个上一次已经被另一个线程写过的变量，那么必须使用同步，
 * 并且，读写线程都必须用相同的监视器锁同步。
 *
 * 根据Brian的同步规则，这里的getValue()需要加锁
 */
public class AtomicityTest implements Runnable {
  private int i = 0;
  public int getValue() { return i; }
  private synchronized void evenIncrement() {
    i++;
    i++;
    System.out.println("i:"+i);
 }
  public void run() {
    while(true)
      evenIncrement();
  }
  public static void main(String[] args) {
    ExecutorService exec = Executors.newCachedThreadPool();
    AtomicityTest at = new AtomicityTest();
    exec.execute(at);
    while(true) {
      int val = at.getValue();
      if(val % 2 != 0) {
        System.out.println("val:"+val);
        System.exit(0);
      }
    }
  }
} /* Output: (Sample)
191583767
*///:~
