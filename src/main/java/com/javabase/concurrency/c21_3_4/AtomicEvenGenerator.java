package com.javabase.concurrency.c21_3_4;//: concurrency/AtomicEvenGenerator.java
// Atomic classes are occasionally useful in regular code.
// {RunByHand}
import com.javabase.concurrency.c21_3_1.EvenChecker;
import com.javabase.concurrency.c21_3_1.IntGenerator;

import java.util.concurrent.atomic.*;

public class AtomicEvenGenerator extends IntGenerator {
  /*特殊情况下才在自己的代码中使用类，通常依赖于锁更安全*/
  private AtomicInteger currentEvenValue =
    new AtomicInteger(0);
  public int next() {
    return currentEvenValue.addAndGet(2);
  }
  public static void main(String[] args) {
    EvenChecker.test(new AtomicEvenGenerator());
  }
} ///:~
