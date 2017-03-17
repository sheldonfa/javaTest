package com.algorithmsforimock;

import com.algorithms.model.StopWatch;
import com.algorithms.model.Tlt;
import com.algorithmsforimock.four.HeapSort;
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

    /**
     * 插入排序、归并排序 比较
     * 归并排序明显更快
     */
    @Test
    public void test3(){
        Integer N = 100000;
        Integer rangeL = -100000;
        Integer rangeR = 100000;
        Integer[] random = Tlt.random(N, rangeL, rangeR);
        Integer[] random2 = Arrays.copyOf(random, random.length);
        StopWatch sw = new StopWatch();
        InsertionSort.sort2(random);
        System.out.println("优化插入排序耗时："+sw.elapsedTime());
        StopWatch sw2 = new StopWatch();
        MergeSort.sort(random2);
        System.out.println("归并排序耗时："+sw2.elapsedTime());
    }

    /**
     * 插入排序、归并排序 比较
     * 在近乎有序的情况下，插入排序更占优势
     */
    @Test
    public void test4(){
        Integer N = 1000000;
        Integer[] random = Tlt.nearlyOrderedRandom(N,10);
        Integer[] random2 = Arrays.copyOf(random, random.length);
        StopWatch sw = new StopWatch();
        InsertionSort.sort2(random);
        System.out.println("优化插入排序耗时："+sw.elapsedTime());
        StopWatch sw2 = new StopWatch();
        MergeSort.sort(random2);
        System.out.println("归并排序耗时："+sw2.elapsedTime());
    }

    /**
     * 简单修改后的归并排序性能测试
     */
    @Test
    public void test5(){
        Integer N = 1000000;
        Integer[] random = Tlt.nearlyOrderedRandom(N,10);
        Integer[] random2 = Arrays.copyOf(random, random.length);
        Integer[] random3 = Arrays.copyOf(random, random.length);
        StopWatch sw = new StopWatch();
        InsertionSort.sort2(random);
        System.out.println("优化的插入排序耗时："+sw.elapsedTime());
        StopWatch sw2 = new StopWatch();
        MergeSort.sort(random2);
        System.out.println("归并排序耗时："+sw2.elapsedTime());
        StopWatch sw3 = new StopWatch();
        MergeSortFast.sort(random3);
        System.out.println("简单优化后的归并排序耗时："+sw3.elapsedTime());
    }

    /**
     * 快速排序、归并排序 比较
     */
    @Test
    public void test6(){
        Integer n = 1000000;
        Integer start = 0;
        Integer end = 1000000;
        Integer[] random = Tlt.random(n,start,end);
        Integer[] random2 = Arrays.copyOf(random, random.length);
        StopWatch sw = new StopWatch();
        QuickSort.sort(random);
        System.out.println("快速排序耗时："+sw.elapsedTime());
        StopWatch sw2 = new StopWatch();
        MergeSortFast.sort(random2);
        System.out.println("简单优化后的归并排序耗时："+sw2.elapsedTime());
    }

    /**
     * 快速排序，在近乎有序的数组中的表现
     * 效果差，退化为on^2
     */
    @Test
    public void test7(){
        Integer n = 200000;
        Integer[] random = Tlt.nearlyOrderedRandom(n,100);
        Integer[] random2 = Arrays.copyOf(random, random.length);
        StopWatch sw = new StopWatch();
        QuickSort.sort(random);
        System.out.println("快速排序耗时："+sw.elapsedTime());
        StopWatch sw2 = new StopWatch();
        MergeSortFast.sort(random2);
        System.out.println("简单优化后的归并排序耗时："+sw2.elapsedTime());
    }

    /**
     * 优化后的快速排序，在近乎有序的数组中的表现
     * 效果很好
     */
    @Test
    public void test8(){
        Integer n = 200000;
        Integer[] random = Tlt.nearlyOrderedRandom(n,100);
        Integer[] random2 = Arrays.copyOf(random, random.length);
        Integer[] random3 = Arrays.copyOf(random, random.length);
        StopWatch sw = new StopWatch();
        MergeSortFast.sort(random);
        System.out.println("简单优化后的归并排序耗时："+sw.elapsedTime());
        StopWatch sw2 = new StopWatch();
        QuickSort.sort(random2);
        System.out.println("快速排序耗时："+sw2.elapsedTime());
        StopWatch sw3 = new StopWatch();
        QuickSortFast.sort(random3);
        System.out.println("优化后的快速排序耗时："+sw3.elapsedTime());
    }

    /**
     * 优化后的快速排序，高重复率下的表现
     */
    @Test
    public void test9(){
        Integer n = 1000000;
        Integer[] random = Tlt.random(n,0,10);
        Integer[] random2 = Arrays.copyOf(random, random.length);
        Integer[] random3 = Arrays.copyOf(random, random.length);
        StopWatch sw = new StopWatch();
        MergeSortFast.sort(random);
        System.out.println("简单优化后的归并排序耗时："+sw.elapsedTime());
        StopWatch sw2 = new StopWatch();
        QuickSort.sort(random2);
        System.out.println("快速排序耗时："+sw2.elapsedTime());
        StopWatch sw3 = new StopWatch();
        QuickSortFast.sort(random3);
        System.out.println("优化后的快速排序耗时："+sw3.elapsedTime());
    }

    /**
     * 三路快速排序
     * 在高重复的数组中表现优异，其他情况也不示弱
     */
    @Test
    public void test10(){
        Integer n = 1000000;
        Integer[] random = Tlt.random(n,0,10);
        Integer[] random2 = Arrays.copyOf(random, random.length);
        Integer[] random3 = Arrays.copyOf(random, random.length);
        StopWatch sw = new StopWatch();
        MergeSortFast.sort(random);
        System.out.println("简单优化后的归并排序耗时："+sw.elapsedTime());
        StopWatch sw2 = new StopWatch();
        QuickSortFast.sort(random2);
        System.out.println("优化后的快速排序耗时："+sw2.elapsedTime());
        StopWatch sw3 = new StopWatch();
        QuickSort3Ways.sort(random3);
        System.out.println("三路快速排序耗时："+sw3.elapsedTime());
    }

    /**
     * 堆排序 测试
     */
    @Test
    public void test11(){
        Integer n = 1000000;
        Integer[] random = Tlt.random(n,0,1000000);
        Integer[] random2 = Arrays.copyOf(random, random.length);
        Integer[] random3 = Arrays.copyOf(random, random.length);
        Integer[] random4 = Arrays.copyOf(random, random.length);
        System.out.println("=========普通随机数排序=============");
        StopWatch sw = new StopWatch();
        MergeSortFast.sort(random);
        System.out.println("简单优化后的归并排序耗时："+sw.elapsedTime());
        StopWatch sw2 = new StopWatch();
        QuickSortFast.sort(random2);
        System.out.println("优化后的快速排序耗时："+sw2.elapsedTime());
        StopWatch sw3 = new StopWatch();
        QuickSort3Ways.sort(random3);
        System.out.println("三路快速排序耗时："+sw3.elapsedTime());
        StopWatch sw4 = new StopWatch();
        HeapSort.sort(random4);
        System.out.println("堆排序耗时："+sw4.elapsedTime());

        Integer[] random11 = Tlt.nearlyOrderedRandom(n,100);
        Integer[] random22 = Arrays.copyOf(random, random.length);
        Integer[] random33 = Arrays.copyOf(random, random.length);
        Integer[] random44 = Arrays.copyOf(random, random.length);
        System.out.println("=========近乎有序的数组排序=============");
        StopWatch sw11 = new StopWatch();
        MergeSortFast.sort(random11);
        System.out.println("简单优化后的归并排序耗时："+sw11.elapsedTime());
        StopWatch sw22 = new StopWatch();
        QuickSortFast.sort(random22);
        System.out.println("优化后的快速排序耗时："+sw22.elapsedTime());
        StopWatch sw33 = new StopWatch();
        QuickSort3Ways.sort(random33);
        System.out.println("三路快速排序耗时："+sw33.elapsedTime());
        StopWatch sw44 = new StopWatch();
        HeapSort.sort(random44);
        System.out.println("堆排序耗时："+sw44.elapsedTime());

        Integer[] random111 = Tlt.random(n,0,100);
        Integer[] random222 = Arrays.copyOf(random, random.length);
        Integer[] random333 = Arrays.copyOf(random, random.length);
        Integer[] random444 = Arrays.copyOf(random, random.length);
        System.out.println("=========大量重复的数组排序=============");
        StopWatch sw111 = new StopWatch();
        MergeSortFast.sort(random111);
        System.out.println("简单优化后的归并排序耗时："+sw111.elapsedTime());
        StopWatch sw222 = new StopWatch();
        QuickSortFast.sort(random222);
        System.out.println("优化后的快速排序耗时："+sw222.elapsedTime());
        StopWatch sw333 = new StopWatch();
        QuickSort3Ways.sort(random333);
        System.out.println("三路快速排序耗时："+sw333.elapsedTime());
        StopWatch sw444 = new StopWatch();
        HeapSort.sort(random444);
        System.out.println("堆排序耗时："+sw444.elapsedTime());
    }
}
