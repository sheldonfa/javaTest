package com.designPattern.singleton;

/**
 * 多线程下的单例模式，懒汉式
 */
public class Singleton4 {

    private volatile static Singleton4 instance;


    public static Singleton4 getInstance(){
        if(instance == null){
            synchronized (Singleton4.class){
                if(instance==null){
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }

}
