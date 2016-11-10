package com.designPattern.decorator;

/**
 * Created by Administrator on 2016/11/10 0010.
 */
public class Client {

    public static void main(String[] args) {
        ConcrateCoffee concrateCoffee = new ConcrateCoffee();
        ChocolateCoffee chocolateCoffee = new ChocolateCoffee(new MilkCoffee(concrateCoffee));
        chocolateCoffee.getCoffee();
    }
}
