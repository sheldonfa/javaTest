package com.designPattern.strategy;

/**
 * @author fangxin
 * @date 2017/1/4.
 */
public class Duck {

    Flyable fly;

    public Duck(Flyable fly) {
        this.fly = fly;
    }

    public void eat(){
        System.out.println("鸭子在吃");
    }

    public void play(){
        System.out.println("鸭子在游泳");
    }

}
