package com.algorithmsforimock.c3;

import com.algorithms.model.Tlt;

/**
 * 快速排序
 */
public class QuickSort {

    public static void sort(Integer[] arr){
        Integer n = arr.length;
        quickSort(arr,0,n-1);
    }

    private static void quickSort(Integer[] arr, int l, int r) {
        if(l>=r){
            return;
        }
        int p = partition(arr,l,r);
        quickSort(arr,l,p-1);
        quickSort(arr,p+1,r);
    }

    // 返回p，使得arr[l...p-1]<arr[p]; arr[p+1...r]>arr[p]
    private static int partition(Integer[] arr, int l, int r) {
        Integer v = arr[l];
        int j = l;
        for(int i=l+1;i<=r;i++){
            if(arr[i] < v){
                Tlt.exch(arr,j+1,i);
                j++;
            }
        }
        Tlt.exch(arr,l,j);
        return j;
    }

    public static void main(String[] args) {
        Integer[] random = Tlt.random(100000, 0, 100000);
        Integer[] arr = new Integer[]{25,84,21,47,15,27,68,35,20};
        sort(arr);
        Tlt.show(arr);
    }
}
