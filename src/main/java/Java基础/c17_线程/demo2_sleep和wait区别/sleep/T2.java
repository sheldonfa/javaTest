package Java基础.c17_线程.demo2_sleep和wait区别.sleep;

class T2 implements Runnable{

    @Override
    public void run() {
        synchronized (Demo1.class){
            System.out.println("thread 2 启动");
            System.out.println("thread 2 结束");
        }
    }
}
