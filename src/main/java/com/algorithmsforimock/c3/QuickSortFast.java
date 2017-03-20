package com.algorithmsforimock.c3;

import com.algorithms.model.StdRandom;
import com.algorithms.model.Tlt;

/**
 * 快速排序优化
 */
public class QuickSortFast {

    public static void sort(Integer[] arr){
        Integer n = arr.length;
        quickSort(arr,0,n-1);
    }

    private static void quickSort(Integer[] arr, int l, int r) {
        if(r-l<=15){
            InsertionSort.sort2(arr,l,r);
            return;
        }
        int p = partition(arr,l,r);
        quickSort(arr,l,p-1);
        quickSort(arr,p+1,r);
    }

    // 返回p，使得arr[l...p-1]<arr[p]; arr[p+1...r]>arr[p]
    private static int partition(Integer[] arr, int l, int r) {
        // 随机选取标定元素
        Tlt.exch(arr,l,StdRandom.uniform(l, r));
        Integer v = arr[l];
        // arr[l+1...i) <= v; arr[j...r] >= v
        int i = l+1,j = r;
        while(true){
            while(i <=r && arr[i]<v) i++;
            while(j >= l+1 && arr[j]>v) j--;
            if(i>j)break;
            Tlt.exch(arr,i,j);
            i++;
            j--;
        }
        Tlt.exch(arr,l,j);
        return j;
    }

    public static void main(String[] args) {
        Integer[] random = Tlt.random(100000, 0, 100000);
        sort(random);
        Tlt.show(random);
    }
}
