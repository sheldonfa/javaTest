package com.algorithmsforimock.practice;

import com.algorithms.model.Tlt;

import java.util.Arrays;

/**
 * @author fangxin
 * @description ${END}
 * @date 2017/3/16 0016.
 */
public class Practice1 {

    public static void selectSort(Integer[] arr){
        Integer n = arr.length;

        for(int i=0;i<n;i++){
            int min = i;
            for(int j=i;j<n;j++){
                if(Tlt.less(arr[j],arr[min])){
                    min = j;
                }
            }
            Tlt.exch(arr,min,i);
        }
    }

    public static void insertSort(Integer[] arr){
        Integer n = arr.length;
        for(int i=1;i<n;i++){
            for(int j=i;j>0;j--){
                if(Tlt.less(arr[j],arr[j-1])){
                    Tlt.exch(arr,j,j-1);
                }
            }
        }
    }

    public static void insertSortFast(Integer[] arr){
        Integer n = arr.length;
        for(int i=1;i<n;i++){
            int e = arr[i];
            int j;
            for(j=i;j>0 && Tlt.less(e,arr[j-1]);j--){
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }
    }

    public static void main(String[] args) {
        Integer[] random = Tlt.random(100, 0, 100);
        Integer[] random2 = Arrays.copyOf(random, random.length);
        Integer[] random3 = Arrays.copyOf(random, random.length);
        selectSort(random);
        insertSort(random2);
        insertSortFast(random3);
        Tlt.show(random);
        Tlt.show(random2);
        Tlt.show(random3);
    }
}
