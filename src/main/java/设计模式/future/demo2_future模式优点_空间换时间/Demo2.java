package 设计模式.future.demo2_future模式优点_空间换时间;

import java.util.concurrent.*;


class NewA implements Callable<String>{


    @Override
    public String call() throws Exception {
        try {
            Thread.sleep(2000);
            System.out.println("A run over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "a result";
    }
}

class NewB implements Callable<String>{

    @Override
    public String call() throws Exception {
        try {
            Thread.sleep(2000);
            System.out.println("B run over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "b result";
    }
}
public class Demo2 {

    public String run() throws ExecutionException, InterruptedException {
        FutureTask<String> taskA = new FutureTask<>(new NewA());
        FutureTask<String> taskB = new FutureTask<>(new NewB());
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(taskA);
        executor.submit(taskB);
        String a = taskA.get();
        String b = taskB.get();
        executor.shutdown();
        return a+b;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Demo2 demo2 = new Demo2();
        System.out.println(demo2.run());
    }

}
