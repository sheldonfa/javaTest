package com.designPattern.decorator.coffee;

import com.designPattern.decorator.coffee.ChocolateCoffee;
import com.designPattern.decorator.coffee.ConcrateCoffee;
import com.designPattern.decorator.coffee.MilkCoffee;

/**
 * Created by Administrator on 2016/11/10 0010.
 */
public class Client {

    /**
     * 咖啡例子 装饰模式
     * @param args
     */
    public static void main(String[] args) {
        ConcrateCoffee concrateCoffee = new ConcrateCoffee();
        ChocolateCoffee chocolateCoffee = new ChocolateCoffee(new MilkCoffee(concrateCoffee));
        chocolateCoffee.getCoffee();
    }


}
