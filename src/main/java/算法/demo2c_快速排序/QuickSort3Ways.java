package 算法.demo2c_快速排序;

import com.algorithms.model.StdRandom;
import com.algorithms.model.Tlt;
import com.algorithmsforimock.c3.InsertionSort;

/**
 * 三路快速排序
 */
public class QuickSort3Ways {

    public static void sort(Integer[] arr){
        Integer n = arr.length;
        quickSort3Ways(arr,0,n-1);
    }

    private static void quickSort3Ways(Integer[] arr, int l, int r) {
        if(r-l<=15){
            InsertionSort.sort2(arr,l,r);
            return;
        }
        Tlt.exch(arr,l,StdRandom.uniform(l, r));
        Integer v = arr[l];
        // arr[l+1...lt] < v    arr[gt...r] > v   // arr[lt+1...i] == v
        int lt= l,gt = r+1,i = l+1;
        while(i<gt){
            if(arr[i] < v){
                Tlt.exch(arr,i,lt+1);
                lt++;
                i++;
            }else if(arr[i]>v){
                Tlt.exch(arr,i,gt-1);
                gt--;

            }else{
                i++;
            }
        }
        Tlt.exch(arr,l,lt);
        quickSort3Ways(arr,l,lt-1);
        quickSort3Ways(arr,gt,r);
    }

    public static void main(String[] args) {
        Integer[] random = Tlt.random(100000, 0, 100000);
        sort(random);
        Tlt.show(random);
    }
}
