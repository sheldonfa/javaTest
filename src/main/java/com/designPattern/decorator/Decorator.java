package com.designPattern.decorator;

/**
 * Created by Administrator on 2016/11/10 0010.
 * Decorator 可以是接口，也可以是抽象类。也可以是普通类，但是子类就有可能因为不知道必须要实现那些方法而错误
 */
public abstract class Decorator implements Coffee {

    public abstract void getCoffee();
}
