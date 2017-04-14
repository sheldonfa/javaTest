package com.designPattern.singleton;

/**
 * 经典单例模式
 * @author fangxin
 * @date 2017/4/13.
 */
public class Singleton {

    private static Singleton instance;

    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

}
