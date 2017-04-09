package com.algorithmsforimock.practice.test1;

import com.algorithms.model.StdRandom;
import com.algorithms.model.StopWatch;
import com.algorithms.model.Tlt;
import org.junit.Test;

/**
 * @author fangxin
 * @date 2017/4/9.
 */
public class TestSort1 {


    /**
     * 插入排序，优化前后比较
     */
    public static void test1(String[] args) {
        Integer[] random = Tlt.random(10000, 0, 10000);
        Integer[] random2 = Tlt.copy(random);
        testInsertionSort(random);
        testInsertionSort2(random2);
    }

    /**
     * 插入排序，与快速排序比较
     * 如果 数组是相对有序的情况
     * 如果 数组是很多重复的情况
     */
    @Test
    public void test2(){
        Integer[] random = Tlt.nearlyOrderedRandom(10000, 5);
        Integer[] random2 = Tlt.copy(random);
        testInsertionSort2(random);
        testQuickSort(random2);
    }
    @Test
    public void test3(){
        Integer[] random = Tlt.random(50000, 0,3);
        Integer[] random2 = Tlt.copy(random);
        testInsertionSort2(random);
        testQuickSort(random2);
    }

    /**
     * 优化后的快速排序与简单快速排序，优化插入排序比较
     * 在高有序的情况下，优化后有所好转
     */
    @Test
    public void test4(){
        Integer[] random = Tlt.nearlyOrderedRandom(10000, 5);
        Integer[] random2 = Tlt.copy(random);
        Integer[] random3 = Tlt.copy(random);
        testInsertionSort2(random);
        testQuickSort(random2);
        testQuickSortFast(random3);
    }

    /**
     * 优化后的快速排序与简单快速排序，优化插入排序比较
     * 在高重复的情况下，优化后没有好转
     */
    @Test
    public void test5(){
        Integer[] random = Tlt.random(10000, 0,3);
        Integer[] random2 = Tlt.copy(random);
        Integer[] random3 = Tlt.copy(random);
        testInsertionSort2(random);
        testQuickSort(random2);
        testQuickSortFast(random3);
    }

    /**
     * 解决高重复问题，三路快排
     */
    @Test
    public void test6(){
        Integer[] random = Tlt.random(10000, 0,3);
        Integer[] random2 = Tlt.copy(random);
        Integer[] random3 = Tlt.copy(random);
        Integer[] random4 = Tlt.copy(random);
        testInsertionSort2(random);
        testQuickSort(random2);
        testQuickSortFast(random3);
        testQuickSort3Ways(random4);

    }

    /**
     * 归并排序测试，明显优于插入排序
     */
    @Test
    public void test7(){
        Integer[] random = Tlt.random(50000, 0,100000);
        Integer[] random2 = Tlt.copy(random);
        testInsertionSort2(random);
        testMergeSort(random2);
    }

    /**
     * 在近乎有序的情况下，插入排序优于归并排序
     */
    @Test
    public void test8(){
        Integer[] random = Tlt.nearlyOrderedRandom(10000, 5);
        Integer[] random2 = Tlt.copy(random);
        testInsertionSort2(random);
        testMergeSort(random2);
    }

    private static void testInsertionSort(Integer[] random) {
        StopWatch sw = new StopWatch();
        insertionSort(random);
        System.out.println("插入排序："+sw.elapsedTime());
        Tlt.show(random);
    }

    private static void testInsertionSort2(Integer[] random) {
        StopWatch sw = new StopWatch();
        insertionSort2(random);
        System.out.println("优化的插入排序："+sw.elapsedTime());
        Tlt.show(random);
    }

    private static void testQuickSort(Integer[] random) {
        StopWatch sw = new StopWatch();
        quickSort(random);
        System.out.println("快速排序："+sw.elapsedTime());
        Tlt.show(random);
    }

    private static void testQuickSortFast(Integer[] random) {
        StopWatch sw = new StopWatch();
        quickSortFast(random);
        System.out.println("优化快速排序："+sw.elapsedTime());
        Tlt.show(random);
    }

    private static void testQuickSort3Ways(Integer[] random) {
        StopWatch sw = new StopWatch();
        quickSort3Ways(random);
        System.out.println("三路快速排序："+sw.elapsedTime());
        Tlt.show(random);
    }

    private static void testMergeSort(Integer[] random) {
        StopWatch sw = new StopWatch();
        mergeSort(random);
        System.out.println("归并排序："+sw.elapsedTime());
        Tlt.show(random);
    }

    /**
     * 简单插入排序
     */
    public static void insertionSort(Integer[] arr){
        int n = arr.length;
        for(int i=1;i<n;i++){
            for(int j=i;j>0;j--){
                if(Tlt.less(arr[j],arr[j-1])){
                    Tlt.exch(arr,j,j-1);
                }else{
                    break;
                }
            }
        }
    }

    /**
     * 优化插入排序
     */
    public static void insertionSort2(Integer[] arr){
        int n = arr.length;

        for(int i=1;i<n;i++){
            Integer e = arr[i];
            int j;
            for(j=i;j>0 && Tlt.less(e,arr[j-1]);j--){
                // j-1向后移动
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }
    }

    /**
     * 局部优化插入排序
     */
    private static void insertionSort2(Integer[] arr, int l, int r) {
        for(int i=l;i<=r;i++){
            Integer e = arr[i];
            int j;
            for(j=i;j>0 && Tlt.less(e,arr[j-1]);j--){
                // j-1向后移动
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }
    }

    /**
     * 快速排序
     */
    public static void quickSort(Integer[] arr){
        quickSort(arr,0,arr.length-1);
    }

    private static void quickSort(Integer[] arr, int l, int r) {
        if(l>=r){
            return;
        }
        int p = partition(arr,l,r);
        quickSort(arr,l,p-1);
        quickSort(arr,p+1,r);
    }

    private static int partition(Integer[] arr, int l, int r) {
        int v = arr[l];
        int j = l;// 小于v的index
        for(int i=l+1;i<=r;i++){
            if(Tlt.less(arr[i],v)){
                Tlt.exch(arr,j+1,i);
                j++;
            }
        }
        Tlt.exch(arr,j,l);
        return j;
    }

    /**
     * 优化的快速排序
     */
    public static void quickSortFast(Integer[] arr){
        quickSortFast(arr,0,arr.length-1);
    }

    private static void quickSortFast(Integer[] arr, int l, int r) {
        if(r-l<=15){
            insertionSort2(arr,l,r);
            return;
        }
        int p = partitionFast(arr,l,r);
        quickSortFast(arr,l,p-1);
        quickSortFast(arr,p+1,r);
    }

    private static int partitionFast(Integer[] arr, int l, int r) {
        Tlt.exch(arr,l, StdRandom.uniform(l, r));
        int v = arr[l];
        int i = l+1;
        int j = r;
        while(true){
            while(i<=r && arr[i]<v)i++;
            while(j>=l+1 && arr[j]>v)j--;
            if(i>j){
                break;
            }
            Tlt.exch(arr,i,j);
            i++;
            j--;
        }
        Tlt.exch(arr,l,j);
        return j;
    }

    public static void quickSort3Ways(Integer[] arr){
        quickSort3Ways(arr,0,arr.length-1);

    }

    private static void quickSort3Ways(Integer[] arr, int l, int r) {
        if(r-l<=15){
            insertionSort2(arr,l,r);
            return;
        }
        Tlt.exch(arr,l, StdRandom.uniform(l, r));

        int v = arr[l];
        int lt = l;
        int gt = r+1;
        int i = l+1;

        while(i<gt){
            if(arr[i]>v){
                Tlt.exch(arr,i,gt-1);
                gt--;
            }
            if(arr[i]<v){
                Tlt.exch(arr,i,lt+1);
                lt++;
                i++;
            }
            if(arr[i]==v){
                i++;
            }
        }
        Tlt.exch(arr,l,lt);
        quickSort3Ways(arr,l,lt-1);
        quickSort3Ways(arr,gt,r);
    }

    private static Integer[] aux;

    public static void mergeSort(Integer[] arr){
        aux = new Integer[arr.length];
        sort(arr,0,arr.length-1);
    }

    private static void sort(Integer[] arr, int l, int r) {
        if(l>=r){
            return;
        }
        int mid = l+(r-l)/2;
        sort(arr,l,mid);
        sort(arr,mid+1,r);
        merge(arr,l,r,mid);
    }

    private static void merge(Integer[] arr, int l, int r, int mid) {
        // 存储归并空间初始化内容
        for(int i=l;i<=r;i++){
            aux[i-l] = arr[i];
        }

        // 遍历归并空间，实现归并
        int i = l,j = mid+1;
        for(int k=l;k<=r;k++){
            if(i>mid){
                arr[k] = aux[j-l];
                j++;
            }else if(j>r){
                arr[k] = aux[i-l];
                i++;
            }else if(aux[i-l]<aux[j-l]){
                arr[k] = aux[i-l];
                i++;
            }else{
                arr[k] = aux[j-l];
                j++;
            }
        }
    }
}
