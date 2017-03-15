package com.algorithms.model;

import com.algorithms.sort.InsertionSort;
import com.algorithms.sort.SelectionSort;

/**
 * @author fangxin
 * @date 2017/3/14.
 */
public class Tlt {

    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) <0;
    }

    public static void exch(Comparable[] arr, int a, int b){
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void show(Comparable[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a){
        for(int i=1;i<a.length;i++){
            if(less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }

    public static double time(String alg,Comparable[] arr){

        if(alg.equals("Selection")){
            SelectionSort.sort(arr);
        }
        if(alg.equals("Insertion")){
            InsertionSort.sort(arr);
        }
        return 0;
    }

    public static Integer[] random(int N,int rangeL,int rangeR){
        Integer[] a = new Integer[N];
        for(int i=0;i<N;i++){
            a[i] = StdRandom.uniform(rangeL,rangeR);
        }

        return a;
    }
}
