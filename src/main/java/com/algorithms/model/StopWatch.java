package com.algorithms.model;

/**
 * 计时器
 * @author fangxin
 * @description ${END}
 * @date 2017/3/15 0015.
 */
public class StopWatch {

    private final long start;

    public StopWatch(){
        start = System.currentTimeMillis();
    }

    public double elapsedTime(){
        long now = System.currentTimeMillis();
        return (now-start)/1000.0;
    }
}
