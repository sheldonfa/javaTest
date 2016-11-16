package com.junit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 2016/11/13.
 */
public class Client {

    @Test
    public void testAdd(){
        Calculate calculate = new Calculate();
        Assert.assertEquals(8, calculate.add(5,3));
    }
}
