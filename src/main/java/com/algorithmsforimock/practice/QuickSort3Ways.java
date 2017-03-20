package com.algorithmsforimock.practice;

import com.algorithms.model.StdRandom;
import com.algorithms.model.Tlt;
import com.algorithmsforimock.c3.InsertionSort;

import java.util.Arrays;

/**
 * @author fangxin
 * @description ${END}
 * @date 2017/3/20 0020.
 */
public class QuickSort3Ways {

    public static void sort(Integer[] arr){
        int n = arr.length;
        quickSort(arr,0,arr.length-1);
    }

    // arr[l,lt]<v,arr[lt+1,r]>=v
    private static void quickSort(Integer[] arr, int l, int r) {
        if(l>r){
            return;
        }
        Tlt.exch(arr,l, StdRandom.uniform(l,r));
        int v = arr[l];

        int i = l+1;
        int lt = l;
        int gt = r+1;
        while(i<gt){
            if(arr[i]==v){
                i++;
            }else if(arr[i]<v){
                Tlt.exch(arr,i,lt+1);
                i++;
                lt++;
            }else if(arr[i]>v){
                Tlt.exch(arr,i,gt-1);
                gt--;
            }
        }
        Tlt.exch(arr,l,lt);
        quickSort(arr,l,lt-1);
        quickSort(arr,gt,r);
    }

    public static void main(String[] args) {
        Integer[] random = Tlt.random(1000, 0, 1000);
        Integer[] random2 = Arrays.copyOf(random, random.length);
        sort(random);
        Tlt.show(random);
        InsertionSort.sort(random2);
        Tlt.show(random2);
    }

}
