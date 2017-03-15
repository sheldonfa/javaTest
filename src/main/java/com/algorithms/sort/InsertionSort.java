package com.algorithms.sort;

import com.algorithms.model.Tlt;

/**
 * @author fangxin
 * @description ${END}
 * @date 2017/3/15 0015.
 */
public class InsertionSort {

    /**
     * 插入排序
     */
    public static void sort(Comparable[] arr){
        int n = arr.length;
        for(int i=1;i<n;i++){
            for(int j=i;j>0;j--){
                if(Tlt.less(arr[j],arr[j-1])){
                    Tlt.exch(arr,j,j-1);
                }
            }
        }
    }
}
