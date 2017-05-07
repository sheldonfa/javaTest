package Java基础.c17_线程.demo1_实现一个线程的方式;

/**
 *
 * 第二种方式：继承Thread类
 */
public class Thread2 extends Thread{

    private String s;

    public Thread2(String s) {
        this.s = s;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        Thread2 t1 = new Thread2("aaaa");
        Thread2 t2 = new Thread2("bbbbb");
        t1.start();
        t2.start();
    }
}
