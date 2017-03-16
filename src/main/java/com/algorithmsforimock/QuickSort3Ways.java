package com.algorithmsforimock;

import com.algorithms.model.StdRandom;
import com.algorithms.model.Tlt;

/**
 * 三路快速排序
 */
public class QuickSort3Ways {

    public static void sort(Integer[] arr){
        Integer n = arr.length;
        quickSort3Ways(arr,0,n-1);
    }

    private static void quickSort3Ways(Integer[] arr, int l, int r) {
        if(r-l<=15){
            InsertionSort.sort2(arr,l,r);
            return;
        }
        // partition
        Tlt.exch(arr,l,StdRandom.uniform(l, r));
        Integer v = arr[l];

        int lt= l;      // arr[l+1...lt] < v
        int gt = r+1;   // arr[gt...r] > v
        int i = l+1;    // arr[lt+1...i] == v
        while(i<gt){
            if(arr[i] < v){
                Tlt.exch(arr,i,lt+1);
                lt++;
                i++;
            }else if(arr[i]>v){
                Tlt.exch(arr,i,gt-1);
                gt--;

            }else{
                i++;
            }
        }
        Tlt.exch(arr,l,lt);
        quickSort3Ways(arr,l,lt-1);
        quickSort3Ways(arr,gt,r);
    }

    public static void main(String[] args) {
        Integer[] random = Tlt.random(100000, 0, 100000);
        sort(random);
        Tlt.show(random);
    }
}
