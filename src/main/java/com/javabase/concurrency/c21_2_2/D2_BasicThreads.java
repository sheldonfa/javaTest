package com.javabase.concurrency.c21_2_2;//: concurrency/BasicThreads.java
// The most basic use of the Thread class.

public class D2_BasicThreads {
  public static void main(String[] args) {
    Thread t = new Thread(new LiftOff());
    /**
     * start()开启一个线程，之所以可以看到Waiting for LiftOff先执行，是因为打印数据的行为由其他线程负责了，二者不干预
     */
    t.start();
    System.out.println("Waiting for LiftOff");
  }
} /* Output: (90% match)
Waiting for LiftOff
#0(9), #0(8), #0(7), #0(6), #0(5), #0(4), #0(3), #0(2), #0(1), #0(Liftoff!),
*///:~
