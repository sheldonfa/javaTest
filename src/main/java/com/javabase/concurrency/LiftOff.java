package com.javabase.concurrency;

/**
 * @author fangxin
 * @description ${END}
 * @date 2017/3/23 0023.
 */
public class LiftOff implements Runnable {

    private static int threadNu = 0;
    private final int id = ++threadNu;
    private int count = 10;

    @Override
    public void run() {
        while(count>0){
            System.out.print("#"+id+"("+count+")");
            count--;
        }
        System.out.println("liftOff!!");
    }
}
