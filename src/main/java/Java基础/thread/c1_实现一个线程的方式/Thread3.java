package Java基础.thread.c1_实现一个线程的方式;

/**
 *
 * 第二种方式：继承Thread类
 */
public class Thread3 extends Thread{

    private String s;

    public Thread3(String s) {
        this.s = s;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        Thread3 t1 = new Thread3("aaaa");
        Thread3 t2 = new Thread3("bbbbb");
        t1.start();
        t2.start();
    }
}
