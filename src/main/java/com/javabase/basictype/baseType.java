package com.javabase.basictype;

import org.junit.Test;

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


}
