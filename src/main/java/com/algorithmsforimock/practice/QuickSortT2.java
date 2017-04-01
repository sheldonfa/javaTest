package com.algorithmsforimock.practice;

import com.algorithms.model.StdRandom;
import com.algorithms.model.Tlt;

/**
 * @author fangxin
 * @description ${END}
 * @date 2017/4/1 0001.
 */
public class QuickSortT2 {


    public static int partition(Integer[] arr, int l,int r){
        // j记录小于标准值的坐标
        int j = l;
        // 标准值，选择第一个并不好
        Tlt.exch(arr,l,StdRandom.uniform(l, r));
        int v = arr[l];
        for(int i=l+1;i<=r;i++){
            //
            if(Tlt.less(arr[i],v)){
                Tlt.exch(arr,i,j+1);
                j++;
            }
        }
        Tlt.exch(arr,l,j);
        return j;
    }

    public static void sort(Integer arr[],int l,int r){
        if(l>=r){
            return;
        }
        int middle = partition(arr, l, r);
        sort(arr,l,middle-1);
        sort(arr,middle+1,r);

    }

    public static void sort(Integer arr[]){
        int n = arr.length;
        sort(arr,0,n-1);
    }

    public static void main(String[] args) {
        Integer[] random = Tlt.random(100, 0, 1000);
        sort(random);
        Tlt.show(random);
    }
}
