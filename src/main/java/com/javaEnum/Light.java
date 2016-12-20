package com.javaEnum;

/**
 * Created by Administrator on 2016/12/20 0020.
 */
// 1.定义枚举类型

public enum Light {

    /**
     * 我的理解：事先创建好三个对象，这三个对象参数不同，仅此而已
     */
    // 利用构造函数传参
    RED(1), GREEN(3), YELLOW(2);

    // 定义私有变量

    private int nCode;

    // 构造函数，枚举类型只能为私有

    Light(int _nCode) {

        this.nCode = _nCode;

    }

    public int getValue(){
        return this.nCode;
    }

    @Override
    public String toString() {

        return String.valueOf(this.nCode);

    }

}