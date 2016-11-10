package com.designPattern.decorator;

/**
 * Created by Administrator on 2016/11/10 0010.
 */
public class MilkCoffee extends Decorator{

    private Coffee coffee;

    @Override
    public void getCoffee() {
        coffee.getCoffee();
        System.out.println("add milk");
    }

    public MilkCoffee(Coffee coffee) {
        this.coffee = coffee;
    }
}
