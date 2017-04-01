package com.algorithmsforimock.practice;

import com.algorithms.model.Tlt;

/**
 * @author fangxin
 * @description ${END}
 * @date 2017/4/1 0001.
 */
public class SelectSortT1 {

    public static void sort(Integer[] arr){
        int n = arr.length;
        for(int i=0;i<n;i++){
            int min = i;
            for(int j=i+1;j<n;j++){
                if(Tlt.less(arr[j],arr[min])){
                    min = j;
                }
            }
            Tlt.exch(arr,i,min);
        }
    }

    public static void main(String[] args) {
        Integer[] random = Tlt.random(100, 0, 1000);
        sort(random);
        Tlt.show(random);
    }
}
