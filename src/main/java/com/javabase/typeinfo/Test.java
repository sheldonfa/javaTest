package com.javabase.typeinfo;

/**
 * @author fangxin
 * @description ${END}
 * @date 2017/4/7 0007.
 */
public class Test {

    @org.junit.Test
    public void testIsAssignedFrom1() {
        System.out.println("String是Object的父类:" + String.class.isAssignableFrom(Object.class));
    }
}
