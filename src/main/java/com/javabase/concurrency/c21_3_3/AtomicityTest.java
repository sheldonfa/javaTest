package com.javabase.concurrency.c21_3_3;//: concurrency/AtomicityTest.java
import java.util.concurrent.*;

/**
 * getValue方法中，尽管return i是原子操作，但是缺少同步，可以在i的中间状态被读取
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
