package 算法.demo2c_快速排序;

import com.algorithms.model.StdRandom;
import com.algorithms.model.Tlt;
import com.algorithmsforimock.c3.InsertionSort;

/**
 * 快速排序优化
 */
public class QuickSortFast {

    public static void sort(Integer[] arr){
        Integer n = arr.length;
        quickSort(arr,0,n-1);
    }

    private static void quickSort(Integer[] arr, int l, int r) {
        if(r-l<=15){
            InsertionSort.sort2(arr,l,r);
            return;
        }
        int p = partition(arr,l,r);
        quickSort(arr,l,p-1);
        quickSort(arr,p+1,r);
    }

    // 返回p，使得arr[l...p-1]<arr[p]; arr[p+1...r]>arr[p]
    private static int partition(Integer[] arr, int l, int r) {
        // 随机选取标定元素
        Tlt.exch(arr,l,StdRandom.uniform(l, r));
        Integer v = arr[l];
        // arr[l+1...i) <= v; arr[j...r] >= v
        int i = l+1,j = r;
        while(true){
            while(i <=r && arr[i]<v) i++;
            while(j >= l+1 && arr[j]>v) j--;
            if(i>j)break;
            Tlt.exch(arr,i,j);// 这种情况在arr[i]=v=arr[j]的情况下也会交换。但是好在将等于v的数据在part两部分平分了，阻止退化成on^2。
            i++;
            j--;
        }
        Tlt.exch(arr,l,j);
        return j;
    }

    public static void main(String[] args) {
        Integer[] random = Tlt.random(100000, 0, 100000);
        sort(random);
        Tlt.show(random);
    }
}
