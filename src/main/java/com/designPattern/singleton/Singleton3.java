package com.designPattern.singleton;

/**
 * 多线程下的单例模式，饿汉式
 */
public class Singleton3 {

    private static Singleton3 instance = new Singleton3();

    /**
     * 1、如果getInstance()的性能对应用程序不是很关键，就什么都别做（多创建几个实例有什么的啊，啥都不影响）
     *
     * 2、不延迟实例化
     */
    public synchronized static Singleton3 getInstance(){
        return instance;
    }

}
