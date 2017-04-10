package com.algorithmsforimock;

import com.algorithms.model.StopWatch;
import com.algorithms.model.Tlt;
import com.algorithmsforimock.c3.*;
import com.algorithmsforimock.c4.HeapSort;
import com.algorithmsforimock.c4.HeapSort2;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author fangxin
 * @date 2017/3/15.
 */
public class Client {

    /**
     * 选择排序
     */
    @Test
    public void test1a(){
        Integer[] random = Tlt.random(10, 0, 10);
        printOriginArray(random);
        testSelectSort(random);
    }

    /**
     * 插入排序
     */
    @Test
    public void test2a(){
        Integer[] random = Tlt.random(10, 0, 10);
        printOriginArray(random);
        testInsertionSort(random);
    }

    /**
     * 选择排序、插入排序 比较
     * 理论上：插入排序更快，可提前终止内循环
     * 但实际上。。。
     */
    @Test
    public void test2b(){
        Integer[] random = Tlt.random(10000, 0, 10000);
        Integer[] random2 = Tlt.copy(random);
        testSelectSort(random);
        testInsertionSort(random2);
    }


    /**
     * 优化后的插入排序测试
     *
     */
    @Test
    public void test2c(){
        Integer[] random = Tlt.random(10, 0, 10);
        printOriginArray(random);
        testInsertionSort2(random);
    }

    /**
     * 优化插入排序：减少插入次数，一个元素只插入一次
     * 简单排序，插入排序，优化后的插入排序比较
     *
     * 貌似优化之后，可以和选择排序打平手
     */
    @Test
    public void test2d(){
        Integer[] random = Tlt.random(50000, 0,10000);
        Integer[] random2 = Tlt.copy(random);
        Integer[] random3 = Tlt.copy(random);
        testSelectSort(random);
        testInsertionSort(random2);
        testInsertionSort2(random3);
    }

    /**
     * 插入排序的优势在于：对于近乎有序的数组，可以早早地提前终止内循环
     *
     * 当数组局部有序，插入排序优于选择排序。
     * 所以我认为优化后的插入排序总是比选择排序优秀的，最差可以和选择排序打个平手。
     */
    @Test
    public void test2e(){
        Integer[] random = Tlt.nearlyOrderedRandom(10000,5);
        Integer[] random2 = Tlt.copy(random);
        Integer[] random3 = Tlt.copy(random);
        testSelectSort(random);
        testInsertionSort(random2);
        testInsertionSort2(random3);
    }

    /**
     * 归并排序测试
     */
    @Test
    public void test3a(){
        Integer[] random = Tlt.random(10, 0, 10);
        printOriginArray(random);
        testMergeSort(random);
    }

    /**
     * 插入排序、归并排序 比较
     * 归并排序明显更快
     */
    @Test
    public void test3b(){
        Integer[] random = Tlt.random(10000, 0, 10000);
        Integer[] random2 = Tlt.copy(random);
        testInsertionSort2(random);
        testMergeSort(random2);
    }

    /**
     * 插入排序、归并排序 比较
     * 在近乎有序的情况下，插入排序更占优势
     *
     * 另外在小数目的排序上，插入排序更显得直接。
     */
    @Test
    public void test3c(){
        Integer[] random = Tlt.nearlyOrderedRandom(10000,10);
        Integer[] random2 = Tlt.copy(random);
        testInsertionSort2(random);
        testMergeSort(random2);
    }

    /**
     * 简单优化后的归并排序测试
     */
    @Test
    public void test3e(){
        Integer[] random = Tlt.random(10, 0, 10);
        printOriginArray(random);
        testMergeSortFast(random);
    }

    /**
     * 插入排序，归并排序，优化后的归并排序比较
     *
     * 显然，优化后的归并排序，在近乎有序的情况下没有比插入排序差太多
     */
    @Test
    public void test3f(){
        Integer[] random = Tlt.nearlyOrderedRandom(50000,10);
        Integer[] random2 = Tlt.copy(random);
        Integer[] random3 = Tlt.copy(random);
        testInsertionSort2(random);
        testMergeSort(random2);
        testMergeSortFast(random3);
    }

    /**
     * 快速排序测试
     */
    @Test
    public void test4a(){
        Integer[] random = Tlt.random(10, 0, 10);
        printOriginArray(random);
        testQuickSort(random);
    }

    /**
     * 快速排序、归并排序 比较
     *
     * 与归并排序相当
     */
    @Test
    public void test4b(){
        Integer[] random = Tlt.random(10000,0,10000);
        Integer[] random2 = Tlt.copy(random);
        testMergeSortFast(random);
        testQuickSort(random2);
    }

    /**
     * 快速排序，在近乎有序的数组中的表现
     * 效果差，退化为on^2
     */
    @Test
    public void test4c(){
        Integer[] random = Tlt.nearlyOrderedRandom(10000,5);
        Integer[] random2 = Tlt.copy(random);
        Integer[] random3 = Tlt.copy(random);
        testInsertionSort2(random);
        testMergeSortFast(random2);
        testQuickSort(random3);
    }

    /**
     * 优化后的快速排序，在近乎有序的数组中的表现
     *
     * 不比插入排序差多少
     */
    @Test
    public void test8(){
        Integer[] random = Tlt.nearlyOrderedRandom(10000,10);
        Integer[] random2 = Tlt.copy(random);
        Integer[] random3 = Tlt.copy(random);
        testInsertionSort2(random);
        testMergeSortFast(random2);
        testQuickSortFast(random3);
    }

    /**
     * 快速排序、优化后的快速排序，在高重复率下的表现
     *
     * 优化后的快排，表现出众
     */
    @Test
    public void test9(){
        Integer[] random = Tlt.random(10000,0,5);
        Integer[] random2 = Tlt.copy(random);
        Integer[] random3 = Tlt.copy(random);
        Integer[] random4 = Tlt.copy(random);
        testInsertionSort2(random);
        testMergeSortFast(random2);
        testQuickSort(random3);
        testQuickSortFast(random4);
    }

    /**
     * 三路快排
     */
    @Test
    public void test4d(){
        Integer[] random = Tlt.random(10, 0, 10);
        printOriginArray(random);
        testQuickSort3Ways(random);
    }

    /**
     * 三路快速排序
     * 在高重复的数组中表现优异，其他情况也不示弱
     */
    @Test
    public void test10(){
        Integer[] random = Tlt.random(100000,0,10);
        Integer[] random2 = Tlt.copy(random);
        Integer[] random3 = Tlt.copy(random);
        Integer[] random4 = Tlt.copy(random);
        testInsertionSort2(random);
        testMergeSortFast(random2);
        testQuickSortFast(random3);
        testQuickSort3Ways(random4);
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

    /**
     * 堆排序 测试
     */
    @Test
    public void test12(){
        Integer n = 1000000;
        Integer[] random = Tlt.random(n,0,1000000);
        Integer[] random2 = Arrays.copyOf(random, random.length);
        Integer[] random3 = Arrays.copyOf(random, random.length);
        Integer[] random4 = Arrays.copyOf(random, random.length);
        Integer[] random5 = Arrays.copyOf(random, random.length);
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
        StopWatch sw5 = new StopWatch();
        HeapSort.sort2(random5);
        System.out.println("优化的堆排序耗时："+sw5.elapsedTime());

        Integer[] random11 = Tlt.nearlyOrderedRandom(n,100);
        Integer[] random22 = Arrays.copyOf(random, random.length);
        Integer[] random33 = Arrays.copyOf(random, random.length);
        Integer[] random44 = Arrays.copyOf(random, random.length);
        Integer[] random55 = Arrays.copyOf(random, random.length);
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
        StopWatch sw55 = new StopWatch();
        HeapSort.sort2(random55);
        System.out.println("优化的堆排序耗时："+sw55.elapsedTime());

        Integer[] random111 = Tlt.random(n,0,100);
        Integer[] random222 = Arrays.copyOf(random, random.length);
        Integer[] random333 = Arrays.copyOf(random, random.length);
        Integer[] random444 = Arrays.copyOf(random, random.length);
        Integer[] random555 = Arrays.copyOf(random, random.length);
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
        StopWatch sw555 = new StopWatch();
        HeapSort.sort2(random555);
        System.out.println("优化的堆排序耗时："+sw555.elapsedTime());
    }

    /**
     * 原地堆排序测试
     */
    @Test
    public void test13(){
        Integer n = 10000;
        Integer[] random = Tlt.random(n,0,1000000);
        Integer[] random2 = Arrays.copyOf(random, random.length);
        Integer[] random3 = Arrays.copyOf(random, random.length);
        StopWatch sw = new StopWatch();
        HeapSort.sort(random);
        Tlt.show(random);
        System.out.println("堆排序耗时："+sw.elapsedTime());
        StopWatch sw2 = new StopWatch();
        HeapSort.sort2(random2);
        Tlt.show(random2);
        System.out.println("优化的堆排序耗时："+sw2.elapsedTime());
        StopWatch sw3 = new StopWatch();
        HeapSort2.sort(random3);
        Tlt.show(random3);
        System.out.println("原地堆排序耗时："+sw3.elapsedTime());
    }

    private static void testSelectSort(Integer[] random) {
        StopWatch sw = new StopWatch();
        SelectionSort.sort(random);
        System.out.println("选择排序耗时："+sw.elapsedTime());
        Tlt.show(random);
    }

    private static void testInsertionSort(Integer[] random) {
        StopWatch sw = new StopWatch();
        InsertionSort.sort(random);
        System.out.println("插入排序："+sw.elapsedTime());
        Tlt.show(random);
    }

    private static void testInsertionSort2(Integer[] random) {
        StopWatch sw = new StopWatch();
        InsertionSort.sort2(random);
        System.out.println("优化的插入排序："+sw.elapsedTime());
        Tlt.show(random);
    }

    private static void testMergeSort(Integer[] random) {
        StopWatch sw = new StopWatch();
        MergeSort.sort(random);
        System.out.println("归并排序："+sw.elapsedTime());
        Tlt.show(random);
    }

    private static void testMergeSortFast(Integer[] random) {
        StopWatch sw = new StopWatch();
        MergeSortFast.sort(random);
        System.out.println("优化归并排序："+sw.elapsedTime());
        Tlt.show(random);
    }

    private static void testQuickSort(Integer[] random) {
        StopWatch sw = new StopWatch();
        QuickSort.sort(random);
        System.out.println("快速排序："+sw.elapsedTime());
        Tlt.show(random);
    }

    private static void testQuickSortFast(Integer[] random) {
        StopWatch sw = new StopWatch();
        QuickSortFast.sort(random);
        System.out.println("优化快速排序："+sw.elapsedTime());
        Tlt.show(random);
    }

    private static void testQuickSort3Ways(Integer[] random) {
        StopWatch sw = new StopWatch();
        QuickSort3Ways.sort(random);
        System.out.println("三路快速排序："+sw.elapsedTime());
        Tlt.show(random);
    }


    private void printOriginArray(Integer[] random) {
        System.out.println("原始数据");
        Tlt.show(random);
    }

}
