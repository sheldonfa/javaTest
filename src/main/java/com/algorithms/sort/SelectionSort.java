package com.algorithms.sort;

import com.algorithms.model.Tlt;

/**
 * @author fangxin
 * @description ${END}
 * @date 2017/3/15 0015.
 */
public class SelectionSort {

    /**
     * 选择排序
     */
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
