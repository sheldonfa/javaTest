package com.javabase.concurrency.c21_3_3;//: concurrency/SerialNumberGenerator.java

/**
 * 如果你将一个域定义为volatile，那么它就会告诉编译器不要执行任何移除读取和写入操作的优化，
 * 目的是用线程中的局部变量维护对这个域的精确同步
 */
public class SerialNumberGenerator {
  private static volatile int serialNumber = 0;
  public static int nextSerialNumber() {
    return serialNumber++; // Not thread-safe
  }
} ///:~
