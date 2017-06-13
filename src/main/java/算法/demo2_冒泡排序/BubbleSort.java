package 算法.demo2_冒泡排序;

import com.algorithms.model.Tlt;

/**
 * @author fangxin
 * @date 2017/5/10.
 */
public class BubbleSort {

    public static void sort(Integer[] a){
        int n = a.length;
        // 一共循环n-1次就可以了
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if(Tlt.less(a[j+1],a[j])){
                    Tlt.exch(a,j+1,j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
        sort(a);
        for(int i:a){
            System.out.println(i);
        }
    }
}
