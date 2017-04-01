package com.algorithms.c2_1;

import com.algorithms.model.StdOut;
import com.algorithms.model.Tlt;

/**
 * @author fangxin
 * @date 2017/4/1.
 */
public class ShellSort {

    void shellsort3(Integer a[], int n){
        int i, j, gap;
        for (gap = n / 2; gap > 0; gap /= 2){
            for (i = gap; i < n; i++){
                for (j = i - gap; j >= 0 && Tlt.less(a[i],a[j]); j -= gap){
                    Tlt.exch(a,i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{49,38,65,97,26,13,27,49,55,4};
        ShellSort shellSort = new ShellSort();
        shellSort.shellsort3(arr,10);
        Tlt.show(arr);
    }
}
