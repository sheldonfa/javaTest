package com.algorithmsforimock.c4;

/**
 * @author fangxin
 * @date 2017/3/18.
 */
public class HeapSort {

    public static void sort(Integer[] arr){
        Integer n = arr.length;
        MaxHeap maxHeap = new MaxHeap(n);
        for(int i=0;i<n;i++){
            maxHeap.insert(arr[i]);
        }
        for(int i=n-1;i>=0;i--){
            arr[i] = maxHeap.extractMax();
        }
    }

    public static void sort2(Integer[] arr){
        Integer n = arr.length;
        MaxHeap maxHeap = new MaxHeap(arr,n);
        for(int i=n-1;i>=0;i--){
            arr[i] = maxHeap.extractMax();
        }
    }

    public static void main(String[] args) {

    }
}
