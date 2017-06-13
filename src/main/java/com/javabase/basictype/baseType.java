package com.javabase.basictype;

import org.junit.Test;

import java.math.BigInteger;

/**
 * @author fangxin
 * @description ${END}
 * @date 2017/2/27 0027.
 */
public class baseType {

    /**
     * Integer的缓存机制
     */
    @Test
    public void test1(){
        Integer a = 10;
        Integer b = 10;
        System.out.println(a==b);
        Integer c = 1000;
        Integer d = 1000;
        System.out.println(c==d);
    }

    @Test
    public void test2(){
        long a = 99999999999l;
        System.out.println(a);
    }


}
