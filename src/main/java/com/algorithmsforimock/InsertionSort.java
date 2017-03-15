package com.algorithmsforimock;

import com.algorithms.model.StdRandom;
import com.algorithms.model.Tlt;

/**
 * 插入排序
 * 特点：可提前终止内循环，对于局部有序数组更有利
 */
public class InsertionSort {

    /**
     * 简单方式，交换次数较多
     */
    public static void sort(Comparable[] arr){
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
     * 优化方式，一个元素只交换一次
     */
    public static void sort2(Comparable[] arr){
        int n = arr.length;

        for(int i=1;i<n;i++){
            Comparable e = arr[i];
            int j;
            for(j=i;j>0 && Tlt.less(e,arr[j-1]);j--){
                // j-1向后移动
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }
    }

    public static void main(String[] args) {
        Integer[] random = Tlt.random(10000, 0, 10000);
        sort2(random);
        Tlt.show(random);
    }
}
