package Java基础.c17_线程.demo2_sleep和wait区别.sleep;

/**
 * t1sleep之后，虽然让出了cpu，但是t2获取不到锁，阻塞
 */
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new T1());
        Thread t2 = new Thread(new T2());
        t1.start();
        t2.start();
    }
}
