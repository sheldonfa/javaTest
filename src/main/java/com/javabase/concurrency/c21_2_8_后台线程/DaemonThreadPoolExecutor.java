//: net/mindview/util/DaemonThreadPoolExecutor.java
package com.javabase.concurrency.c21_2_8_后台线程;
import com.javabase.concurrency.c21_2_8_后台线程.DaemonThreadFactory;

import java.util.concurrent.*;

public class DaemonThreadPoolExecutor
extends ThreadPoolExecutor {
  public DaemonThreadPoolExecutor() {
    super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS,
      new SynchronousQueue<Runnable>(),
      new DaemonThreadFactory());
  }
} ///:~
