package com.algorithmsforimock.practice;

import com.algorithms.model.StopWatch;
import com.algorithms.model.Tlt;

import java.util.Arrays;

/**
 * @author fangxin
 * @description ${END}
 * @date 2017/3/20 0020.
 */
public class Test {

    private static Comparable[] aux;

    public static void selectSort(Comparable[] arr){
        Integer n = arr.length;
        for(int i=0;i<n;i++){
            int min = i;
            for(int j=i;j<n;j++){
                if(Tlt.less(arr[j],arr[min])){
                    min = j;
                }
            }
            Tlt.exch(arr,i,min);
        }
    }

    public static void insertSort(Comparable[] arr){
        Integer n = arr.length;
        for(int i=1;i<n;i++){
            for(int j=i;j>0;j--){
                if(Tlt.less(arr[j],arr[j-1])){
                    Tlt.exch(arr,j,j-1);
                }
            }
        }
    }

    public static void insertSortFast(Comparable[] arr){
        Integer n = arr.length;
        for(int i=1;i<n;i++){
            Comparable e = arr[i];
            int j;
            for(j=i;j>0 && Tlt.less(e,arr[j-1]);j--){
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }
    }

    // arr[l,r]
    public static void insertSortFast(Comparable[] arr,Integer l,Integer r){
        for(int i=l;i<=r;i++){
            Comparable e = arr[i];
            int j;
            for(j=i;j>l && Tlt.less(e,arr[j-1]);j--){
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }
    }

    public static void mergeSort(Comparable[] arr){
        aux = new Comparable[arr.length];
        sort(arr,0,arr.length-1);
    }

    // arr[l,r];
    private static void sort(Comparable[] arr, Integer l, Integer r){
        if(r-l<15){
            insertSortFast(arr,l,r);
            return;
        }
        Integer mid = (l+r)/2;
        sort(arr,l,mid);
        sort(arr,mid+1,r);
        if(Tlt.less(arr[mid+1],arr[mid])){
            merge(arr,l,mid,r);
        }
    }

    private static void merge(Comparable[] arr,Integer l,Integer mid,Integer r){
        for(int i=l;i<=r;i++){
            aux[i-l] = arr[i];
        }
        int i=l,j=mid+1;
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

    public static void quickSort(Integer[] arr){
        Integer n = arr.length;
        quickSort(arr,0,n-1);
    }

    public static void quickSort(Comparable[] arr,int l,int r){
        if(l>=r){
            return;
        }
        int p = partition(arr, l, r);
        quickSort(arr,l,p);
        quickSort(arr,p+1,r);
    }

    // arr[l,r]
    private static int partition(Comparable[] arr,Integer l,Integer r) {
        Comparable v = arr[l];
        int j = l;
        for(int i=l+1;i<=r;i++){
            if(Tlt.less(arr[i],v)){
                Tlt.exch(arr,i,j+1);
                j++;
            }
        }
        Tlt.exch(arr,l,j);
        return j;
    }


    public static void main(String[] args) {
        Integer[] random = Tlt.random(20000, 0, 10000);
        Integer[] random2 = Arrays.copyOf(random, random.length);
        Integer[] random3 = Arrays.copyOf(random, random.length);
        Integer[] random4 = Arrays.copyOf(random,random.length);
        Integer[] random5 = Arrays.copyOf(random,random.length);
        StopWatch stopWatch = new StopWatch();
        selectSort(random);
        Tlt.show(random);
        System.out.println(stopWatch.elapsedTime());
        StopWatch stopWatch2 = new StopWatch();
        insertSort(random2);
        Tlt.show(random2);
        System.out.println(stopWatch2.elapsedTime());
        StopWatch stopWatch3 = new StopWatch();
        insertSortFast(random3);
        Tlt.show(random3);
        System.out.println(stopWatch3.elapsedTime());
        StopWatch stopWatch4 = new StopWatch();
        mergeSort(random4);
        Tlt.show(random4);
        System.out.println(stopWatch4.elapsedTime());
        StopWatch stopWatch5 = new StopWatch();
        mergeSort(random5);
        Tlt.show(random5);
        System.out.println(stopWatch5.elapsedTime());
    }

    @org.junit.Test
    public void test(){
        Integer[] random = new Integer[]{3,1,4,6,2,0};
        quickSort(random);
        Tlt.show(random);
    }
}
