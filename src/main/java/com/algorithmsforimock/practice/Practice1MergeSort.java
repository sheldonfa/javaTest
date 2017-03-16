package com.algorithmsforimock.practice;

import com.algorithms.model.Tlt;

/**
 * @author fangxin
 * @description ${END}
 * @date 2017/3/16 0016.
 */
public class Practice1MergeSort {

    private static Integer[] aux;

    public static void merge(Integer[] arr,Integer l,Integer mid,Integer r){

        for(int i=l;i<=r;i++){
            aux[i-l] = arr[i];
        }

        int i = l,j=mid+1;
        for(int k=l;k<=r;k++){
            if(i>mid){
                arr[k] = aux[j-l];
                j++;
            }else if(j>r){
                arr[k] = aux[i-l];
                i++;
            }else if(Tlt.less(aux[i-l],aux[j-l])){
                arr[k] = aux[i-l];
                i++;
            }else{
                arr[k] = aux[j-l];
                j++;
            }
        }
    }

    public static void sort(Integer[] arr){
        aux = new Integer[arr.length];
        sort(arr,0,arr.length-1);
    }

    public static void sort(Integer[] arr,Integer l, Integer r){
        Integer mid = (l+r)/2;
        if(l>=r){
            return;
        }
        sort(arr,l,mid);
        sort(arr,mid+1,r);
        if(arr[mid]>arr[mid+1]){
            merge(arr,l,mid,r);
        }
    }

    public static void main(String[] args) {
        Integer[] random = Tlt.random(1000, 0, 1000);
        sort(random);
        Tlt.show(random);
    }
}
