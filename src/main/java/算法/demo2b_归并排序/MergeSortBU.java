package 算法.demo2b_归并排序;

import com.algorithms.model.Tlt;

/**
 * 自底向上的归并排序
 * @author fangxin
 * @date 2017/3/16.
 */
public class MergeSortBU {

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


    public static void sort(Integer[] arr){

        Integer n = arr.length;
        aux = new Comparable[n];
        for(int sz=1;sz<=n;sz+=sz){
            for(int i=0;i+sz<n;i+=sz+sz){
                merge(arr,i,i+sz-1, Tlt.min(i + sz + sz - 1, n - 1));
            }
        }
    }

    public static void main(String[] args) {
        Integer[] random = Tlt.random(10000, 0, 10000);
        sort(random);
        Tlt.show(random);
    }


}
