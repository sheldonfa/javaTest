package com.algorithmsforimock.practice.test1;

import com.algorithms.model.StopWatch;
import com.algorithms.model.Tlt;

/**
 * @author fangxin
 * @date 2017/4/9.
 */
public class Test1 {

    public static void insertionSort(Integer[] arr){
        int n = arr.length;
        for(int i=1;i<n;i++){
            for(int j=i;j>0;j--){
                if(Tlt.less(arr[j],arr[j-1])){
                    Tlt.exch(arr,j,j-1);
                }else{
                    break;
                }
            }
        }
    }

    public static void insertionSort2(Integer[] arr){
        int n = arr.length;

        for(int i=1;i<n;i++){
            Integer e = arr[i];
            int j;
            for(j=i;j>0 && Tlt.less(e,arr[j-1]);j--){
                // j-1向后移动
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }
    }

    public static void main(String[] args) {
        Integer[] random = Tlt.random(10000, 0, 10000);
        Integer[] random2 = Tlt.copy(random);
        testInsertionSort(random,"insertionSort");
        testInsertionSort2(random2,"insertionSort2");
    }

    private static void testInsertionSort(Integer[] random, String method) {
        StopWatch sw = new StopWatch();
        insertionSort(random);
        System.out.println("插入排序："+sw.elapsedTime());
    }

    private static void testInsertionSort2(Integer[] random, String method) {
        StopWatch sw = new StopWatch();
        insertionSort2(random);
        System.out.println("优化的插入排序："+sw.elapsedTime());
    }
}
