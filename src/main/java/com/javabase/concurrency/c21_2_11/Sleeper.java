package com.javabase.concurrency.c21_2_11;

import static net.mindview.util.Print.*;

/**
 * @author fangxin
 * @description ${END}
 * @date 2017/3/24 0024.
 */
public class Sleeper extends Thread{
    private int duration;

    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }
    public void run(){
        try {
            sleep(duration);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }
}
