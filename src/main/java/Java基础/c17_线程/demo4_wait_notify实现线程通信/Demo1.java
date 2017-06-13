package Java基础.c17_线程.demo4_wait_notify实现线程通信;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * 模拟：往一个list中添加数据，如果有敏感数据，通知另一个线程，使其处理
 * 一个不好的实现--轮询
 */
public class Demo1 {

    private volatile static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    System.out.println(Thread.currentThread().getName()+"添加一个元素");
                    list.add("abc");
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    if(list.size() == 5){
                        System.out.println("有敏感数据");
                        throw new RuntimeException();
                    }
                }
            }
        });
        t2.start();
        TimeUnit.MILLISECONDS.sleep(100);
        t1.start();
    }
}
