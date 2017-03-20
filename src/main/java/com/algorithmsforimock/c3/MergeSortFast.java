package com.algorithmsforimock.c3;

import com.algorithms.model.Tlt;

/**
 * 归并排序优化
 */
public class MergeSortFast {

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
        // 当l-r的值很小时，改用插入排序更有优势
        if(r-l<=15){
            com.algorithmsforimock.c3.InsertionSort.sort2(arr,l,r);
            return;
        }
        int mid = (l+r)/2;
        sort(arr,l,mid);
        sort(arr,mid+1,r);
        // 由于A、B两部分都是有序的，所以只有当A的末尾比B的开头大的情况下，才有必要归并，否则本身就是有序的
        if(Tlt.less(arr[mid+1],arr[mid])){
            merge(arr,l,mid,r);
        }
    }

    public static void main(String[] args) {
        Integer[] random = Tlt.random(100, 0, 100);
        sort(random);
        Tlt.show(random);
    }
}
