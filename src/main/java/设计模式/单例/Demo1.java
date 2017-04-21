package 设计模式.单例;

/**
 * 实现单例设计模式
 * @author fangxin
 * @description ${END}
 * @date 2017/4/20 0020.
 */

class Singleton {

    private Singleton() {}

    private static Singleton instance;

    public static Singleton getInstance(){
        if(instance==null){
            return new Singleton();
        }
        return instance;
    }

}

// 饿汉式
class Singleton2 {

    private Singleton2() {}

    private static Singleton2 instance = new Singleton2();

    public static Singleton2 getInstance(){
        return instance;
    }

}

// 懒汉式
class Singleton3 {

    private Singleton3() {}

    private static Singleton3 instance;

    public static Singleton3 getInstance(){

        if(instance==null){
            synchronized (Singleton3.class){
                if(instance==null){
                    return new Singleton3();
                }
            }
        }
        return instance;
    }

}


public class Demo1 {

    public static void main(String[] args) {
        // 单线程
        Singleton instance = Singleton.getInstance();
        // 多线程：饿汉式
        Singleton2 instance2 = Singleton2.getInstance();
        // 多线程：懒汉式
        Singleton3 instance3 = Singleton3.getInstance();
    }

}
