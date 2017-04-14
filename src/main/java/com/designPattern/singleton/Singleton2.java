package com.designPattern.singleton;

/**
 * 多线程下的单例模式，但并不完善
 * @author fangxin
 * @date 2017/4/13.
 */
public class Singleton2 {

    private static Singleton2 instance;

    /**
     * 加同步锁虽然可以解决问题，但是
     * 1、同步降低性能，
     * 2、只有第一次访问需要创建实例的时候，同步是有意义的，一旦实例生成，同步毫无意义
     */
    public synchronized static Singleton2 getInstance(){
        if(instance == null){
            instance = new Singleton2();
        }
        return instance;
    }

}
