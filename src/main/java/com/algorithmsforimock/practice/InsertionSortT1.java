package com.algorithmsforimock.practice;

import com.algorithms.model.StdRandom;
import com.algorithms.model.Tlt;

/**
 * @author fangxin
 * @description ${END}
 * @date 2017/4/1 0001.
 */
public class InsertionSortT1 {

    public static void sort(Integer[] arr){
        int n = arr.length;

        for(int i=1;i<n;i++){
            int e = arr[i];
            int j = i;
            for(;j>0 && Tlt.less(e,arr[j-1]);j--){
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = Tlt.random(100, 0, 100);
        sort(arr);
        Tlt.show(arr);
    }
}
