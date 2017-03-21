package com.algorithmsforimock.practice;

import java.util.Arrays;

/**
 * @author fangxin
 * @description ${END}
 * @date 2017/3/21 0021.
 */
public class QuickSort {

    static long count = 1;
    //arr[l+1,j]<v arr[j+1,high]>v
    static int partition(int[] array, int low, int high) {
        // 基准值
        int v = array[low];
        // low区域的最大指针
        int i = low;
        // 当前正在考察的值
        int j = low;
        // high区域的最大指针
        int k = low;
        for(;j <= high;j++){
            k++;
            if(v > array[j]){
                int tmp = array[i+1];
                array[i+1] = array[j];
                array[j] = tmp;
                i++;
            }
        }
        array[low] = array[i];
        array[i] = v;
        return i;
    }
    static void quickSort(int[] array,int low,int high){
        if(low >= high ){
            return;
        }
        int p = partition(array, low, high);
        quickSort(array,low,p-1);
        quickSort(array,p+1,high);
    }
    static void sort(int[] array){
        quickSort(array,0,array.length-1);
    }
    public static void main(String[] args) {
        int[] array = { 4, 7, 8, 3, 1, 6, 9, 0, 5, 2 };
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
