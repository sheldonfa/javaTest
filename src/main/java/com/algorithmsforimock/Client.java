package com.algorithmsforimock;

import com.algorithms.model.StopWatch;
import com.algorithms.model.Tlt;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author fangxin
 * @date 2017/3/15.
 */
public class Client {

    /**
     * 选择排序、插入排序 比较
     * 插入排序更快，可提前终止内循环
     */
    @Test
    public void test1(){
        Integer N = 100000;
        Integer rangeL = -100000;
        Integer rangeR = 100000;
        Integer[] random = Tlt.random(N, rangeL, rangeR);
        Integer[] random2 = Arrays.copyOf(random, random.length);
        StopWatch sw = new StopWatch();
        SelectionSort.sort(random);
        System.out.println("选择排序耗时："+sw.elapsedTime());
        StopWatch sw2 = new StopWatch();
        InsertionSort.sort(random2);
        System.out.println("插入排序耗时："+sw2.elapsedTime());

    }

    /**
     * 插入排序优化：减少插入次数，一个元素只插入一次
     */
    @Test
    public void test2(){
        Integer N = 100000;
        Integer rangeL = -100000;
        Integer rangeR = 100000;
        Integer[] random = Tlt.random(N, rangeL, rangeR);
        Integer[] random2 = Arrays.copyOf(random, random.length);
        StopWatch sw = new StopWatch();
        InsertionSort.sort(random);
        System.out.println("简单插入排序耗时："+sw.elapsedTime());
        StopWatch sw2 = new StopWatch();
        InsertionSort.sort2(random2);
        System.out.println("优化插入排序耗时："+sw2.elapsedTime());

    }
}
