package com.javabase.concurrency.c21_2_2;//: concurrency/MainThread.java


public class D1_MainThread {
  public static void main(String[] args) {
    LiftOff launch = new LiftOff();
    /**
     * run只是个普通的方法，直接调用run没有什么特别的
     */
    launch.run();
  }
} /* Output:
#0(9), #0(8), #0(7), #0(6), #0(5), #0(4), #0(3), #0(2), #0(1), #0(Liftoff!),
*///:~
