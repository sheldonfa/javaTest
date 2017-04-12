package com.javabase.concurrency.c21_2_4_从任务中产生返回值;//: concurrency/CallableDemo.java
import java.util.concurrent.*;
import java.util.*;

/**
 * 实现Runnable接口不反回任何值，如果有需要，可以考虑Callable接口
 */
class TaskWithResult implements Callable<String> {
  private int id;
  public TaskWithResult(int id) {
    this.id = id;
  }
  public String call() {
    return "result of TaskWithResult " + id;
  }
}

public class CallableDemo {
  public static void main(String[] args) {
    ExecutorService exec = Executors.newCachedThreadPool();
    ArrayList<Future<String>> results =
      new ArrayList<Future<String>>();
    for(int i = 0; i < 10; i++)
    /**
     * 实现Callable接口的线程，必须使用ExecutorService的submit方法调用。
     * submit方法产生Future对象
     *
     * isDone方法可以查询Future是否完成。当任务完成时，返回一个结果，可用get方法获取
     * 直接用get会阻塞，直至结果返回。
     */
      results.add(exec.submit(new TaskWithResult(i)));
    for(Future<String> fs : results)
      try {
        // get() blocks until completion:
        System.out.println(fs.get());
      } catch(InterruptedException e) {
        System.out.println(e);
        return;
      } catch(ExecutionException e) {
        System.out.println(e);
      } finally {
        exec.shutdown();
      }
  }
} /* Output:
result of TaskWithResult 0
result of TaskWithResult 1
result of TaskWithResult 2
result of TaskWithResult 3
result of TaskWithResult 4
result of TaskWithResult 5
result of TaskWithResult 6
result of TaskWithResult 7
result of TaskWithResult 8
result of TaskWithResult 9
*///:~
