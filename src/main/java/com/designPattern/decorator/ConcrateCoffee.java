package com.designPattern.decorator;

/**
 * Created by Administrator on 2016/11/10 0010.
 */
public class ConcrateCoffee implements Coffee {

    @Override
    public void getCoffee() {
        System.out.println("a cup of coffee");
    }
}
