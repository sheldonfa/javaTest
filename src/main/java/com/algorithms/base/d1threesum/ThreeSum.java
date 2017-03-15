package com.algorithms.base.d1threesum;



import com.algorithms.model.In;
import com.algorithms.model.StdOut;
import com.algorithms.model.StopWatch;


/**
 * 计算数组中三个数的和为0
 * 数组文件如下
 * http://algs4.cs.princeton.edu/14analysis/1Kints.txt
 * http://algs4.cs.princeton.edu/14analysis/2Kints.txt
 * http://algs4.cs.princeton.edu/14analysis/4Kints.txt
 * http://algs4.cs.princeton.edu/14analysis/8Kints.txt
 * http://algs4.cs.princeton.edu/14analysis/16Kints.txt
 * http://algs4.cs.princeton.edu/14analysis/32Kints.txt
 * http://algs4.cs.princeton.edu/14analysis/1Mints.txt
 */
public class ThreeSum {
    public static int count(int[] a){
        int N = a.length;
        int cnt = 0;
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                for(int k = j+1;k<N;k++){
                    if(a[i]+a[j]+a[k]==0){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        String arr1 = "http://algs4.cs.princeton.edu/14analysis/1Kints.txt";
        String arr2 = "http://algs4.cs.princeton.edu/14analysis/2Kints.txt";
        String arr4 = "http://algs4.cs.princeton.edu/14analysis/4Kints.txt";
        String arr8 = "http://algs4.cs.princeton.edu/14analysis/4Kints.txt";
        // 4Kints.txt中包含1Mints.txt中的4000个数字，已经很慢了
        int[] a = In.readInts(arr4);
        StopWatch watch = new StopWatch();
        StdOut.println(count(a));
        System.out.println(watch.elapsedTime());
    }
}
