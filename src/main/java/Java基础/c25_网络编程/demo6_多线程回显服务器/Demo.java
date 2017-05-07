package Java基础.c25_网络编程.demo6_多线程回显服务器;

/**
 * Created by Administrator on 2017/5/7 0007.
 */
public class Demo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new EchoClient());
        Thread t2 = new Thread(new EchoClient());
        Thread t3 = new Thread(new EchoClient());
        t1.start();
        t2.start();
        t3.start();
    }
}
