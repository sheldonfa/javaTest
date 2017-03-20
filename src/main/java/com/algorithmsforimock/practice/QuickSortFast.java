package com.algorithmsforimock.practice;

import com.algorithms.model.StdRandom;
import com.algorithms.model.Tlt;

/**
 * @author fangxin
 * @description ${END}
 * @date 2017/3/20 0020.
 */
public class QuickSortFast {

    public static void sort(Comparable[] arr){
        int n = arr.length;
        quickSort(arr,0,n-1);
    }

    private static void quickSort(Comparable[] arr, int l, int r) {
        if(r-l<=15){
            Test.insertSortFast(arr,l,r);
            return;
        }
        int p = partition(arr,l,r);
        quickSort(arr,l,p);
        quickSort(arr,p+1,r);
    }

    private static int partition(Comparable[] arr, int l, int r) {
        Tlt.exch(arr,l,StdRandom.uniform(l, r));
        Comparable v = arr[l];
        int i = l,j=r;
        while (true){
            while(i<=r && Tlt.less(arr[i],v)){
                i++;
            }
            while(j>=l+1 && Tlt.less(v,arr[j])){
                j--;
            }
            if(i>j) break;
            Tlt.exch(arr,i,j);
            i++;
            j++;
        }
        Tlt.exch(arr,l,j);
        return j;
    }

    public static void main(String[] args) {
        Integer[] random = new Integer[]{3,1,4,6,2,0};
        sort(random);
        Tlt.show(random);
    }
}
