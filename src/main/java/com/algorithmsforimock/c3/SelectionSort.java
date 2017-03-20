package com.algorithmsforimock.c3;

import com.algorithms.model.Tlt;

/**
 * 选择排序
 */
public class SelectionSort {

    public static void sort(Comparable[] arr){
        int n = arr.length;
        for(int i=0;i<n;i++){
            int minIndex = i;
            for(int j=i+1;j<n;j++){
                if(Tlt.less(arr[j],arr[minIndex])){
                    minIndex = j;
                }
            }
            Tlt.exch(arr,i,minIndex);
        }
    }

}
