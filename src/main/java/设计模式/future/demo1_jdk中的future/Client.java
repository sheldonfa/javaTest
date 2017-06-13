package 设计模式.future.demo1_jdk中的future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author fangxin
 * @date 2017/5/8.
 */
public class Client {

    public static void main(String[] args) throws Exception {
        FutureTask<String> futureTask =
                new FutureTask<String>(new RealData("name"));
        //使用线程池
        ExecutorService executor =
                Executors.newFixedThreadPool(1);
        executor.submit(futureTask);
        //在处理这些业务逻辑过程中，RealData也正在创建，从而充分了利用等待时间
        System.out.println("开始获取数据，这里可能阻塞");
        System.out.println("数据=" + futureTask.get());
        executor.shutdown();
    }
}
