package Java基础.thread.c1_实现一个线程的方式;

/**
 * 第一种方式：实现一个Runnable接口的方式
 */
public class Thread1 implements Runnable {

    private String threadName;

    private long i = 0;

    public Thread1(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        while(true){
            System.out.printf("%s:%d\n",threadName,i++);
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Thread1("AAAAAA"));
        Thread t2 = new Thread(new Thread1("BBB"));
        t1.start();
        t2.start();
    }
}
