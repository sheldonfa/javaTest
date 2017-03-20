package com.algorithmsforimock.c4;

import com.algorithms.model.Tlt;

/**
 * 原地堆排序
 * @author fangxin
 * @date 2017/3/20.
 */
public class HeapSort2 {

    public static void sort(Integer[] arr){
        int n = arr.length;
        for(int i=(n-1)/2;i>=0;i--){
            shiftDown(arr,n,i);
        }
        for(int i=n-1;i>0;i--){
            Tlt.exch(arr,0,i);
            shiftDown(arr,i,0);
        }
    }

    private static void shiftDown(Integer[] arr, int n, int k) {// arr数组，n个元素，尝试shiftDown k索引所在位置
        while(2*k+1<n){ // 左子节点不越界
            int j = 2*k+1;
            if(j+1 < n && arr[j+1]>arr[j]){
                j +=1;
            }
            if(arr[k]>=arr[j]){
                break;
            }
            Tlt.exch(arr,k,j);
            k = j;
        }
    }

    public static void main(String[] args) {
        Integer[] random = Tlt.random(10000, 0, 10000);
        sort(random);
        Tlt.show(random);
    }
}
