package Java基础.c17_线程.demo1_实现一个线程的方式;

/**
 * 第一种方式的匿名写法
 */
public class Thread1a {

    public static void main(String[] args) {
        /**
         * 匿名内部类的方式
         */
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while (i<10000){
                    System.out.println("aaaa");
                    i++;
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while (i<10000){
                    System.out.println("bbb");
                    i++;
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
