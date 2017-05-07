package Java基础.c17_线程.demo2_sleep和wait区别.wait;

class T3 implements Runnable{

    @Override
    public void run() {
        synchronized (Demo2.class){
            try {
                System.out.println("thread 3 启动");
                System.out.println("thread3 wait()");
                Demo2.class.wait();
                System.out.println("thread3 结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
