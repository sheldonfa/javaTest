package com.designPattern.decorator.coffee;

/**
 * Created by Administrator on 2016/11/10 0010.
 */
public class ChocolateCoffee extends Decorator{

        private Coffee coffee;

        @Override
        public void getCoffee() {
            coffee.getCoffee();
            System.out.println("add chocolate");
        }

        public ChocolateCoffee(Coffee coffee) {
            this.coffee = coffee;
        }
}
