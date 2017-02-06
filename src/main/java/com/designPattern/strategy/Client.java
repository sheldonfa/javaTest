package com.designPattern.strategy;

import org.junit.Test;

/**
 * @author fangxin
 * @date 2017/1/4.
 */
public class Client {

    @Test
    public void test1(){
//        Duck duck = new Duck();
//
//        duck.eat();
//        duck.play();
    }

    /**
     * 策略模式：本质上是 组合的一种 应用
     * 理解：我的父（调用者），包含你的父（提供者）；那么我的子，就能使用你的子
     */
    @Test
    public void test2(){
        Duck duck = new WildDuck(new FlyJet());

        duck.eat();
        duck.play();
        duck.fly.fly();
    }


}
