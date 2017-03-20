package com.algorithmsforimock.c3;

import com.algorithms.model.Tlt;

/**
 * 归并排序
 * 特点：NlogN级别的排序。将N分为log以2为底N的对数层，忽略常数即logN层，每层线性排序ON忽略O，总共就是NlogN级别
 */
public class MergeSort {

    // 辅助数组
    private static Comparable[] aux;

    public static void merge(Comparable[] arr,int l,int mid,int r){

        for(int i=l;i<=r;i++){
            aux[i-l] = arr[i];
        }

        int i = l, j = mid+1;
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

    public static void sort(Comparable[] arr){
        aux = new Comparable[arr.length];
        sort(arr,0,arr.length-1);
    }

    public static void sort(Comparable[] arr,int l,int r){
        if(l>=r) return;
        int mid = (l+r)/2;
        sort(arr,l,mid);
        sort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }

    public static void main(String[] args) {
        Integer[] random = Tlt.random(10000, 0, 10000);
        sort(random);
        Tlt.show(random);
    }
}
