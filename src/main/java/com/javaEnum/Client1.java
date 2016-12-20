package com.javaEnum;

/**
 * Created by Administrator on 2016/12/20 0020.
 * enum常用方法简介
 */

public class Client1 {
    public static void main(String[] args) {
        /**
         * values()：返回enum实例的数组
         */
        for(Festival f: Festival.values()){
            /**
             * ordinal()返回下标，从0开始
             */
            System.out.println(f.ordinal());
            /**
             * enum 可以用==判断，效果和equals一样
             */
            System.out.println(f == Festival.AUTOM);
            System.out.println(f.equals(Festival.AUTOM));
            /**
             * name() 返回声明时的名称，效果和toString一样
             */
            System.out.println(f.name());
            /**
             * 打印声明时的名称，可以重写
             */
            System.out.println(f);
        }
        /**
         * valueOf(): Enum静态方法，根据名字返回实例，如果不存在抛异常
         */
        for(String s: "SPRING SUMMER AUTOM WINTER".split(" ")){
            Enum anEnum = Enum.valueOf(Festival.class,s);
            System.out.println(anEnum);
        }
    }
}
