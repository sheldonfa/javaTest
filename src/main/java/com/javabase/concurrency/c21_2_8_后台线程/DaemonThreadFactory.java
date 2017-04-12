//: net/mindview/util/DaemonThreadFactory.java
package com.javabase.concurrency.c21_2_8_后台线程;
import java.util.concurrent.*;

public class DaemonThreadFactory implements ThreadFactory {
  public Thread newThread(Runnable r) {
    Thread t = new Thread(r);
    t.setDaemon(true);
    return t;
  }
} ///:~
