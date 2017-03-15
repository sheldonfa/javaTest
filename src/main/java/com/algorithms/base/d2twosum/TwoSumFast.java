package com.algorithms.base.d2twosum;

import com.algorithms.model.In;
import com.algorithms.model.StdOut;
import com.algorithms.search.BinarySearch;

import java.util.Arrays;

/**
 * 计算两个数和为0，优化后的代码
 *
 * http://algs4.cs.princeton.edu/14analysis/1Kints.txt
 * http://algs4.cs.princeton.edu/14analysis/2Kints.txt
 * http://algs4.cs.princeton.edu/14analysis/4Kints.txt
 * http://algs4.cs.princeton.edu/14analysis/8Kints.txt
 * http://algs4.cs.princeton.edu/14analysis/16Kints.txt
 * http://algs4.cs.princeton.edu/14analysis/32Kints.txt
 * http://algs4.cs.princeton.edu/14analysis/1Mints.txt
 */
public class TwoSumFast {

    public static int count(int[] a){
        // 计算和为0的整数对的数目
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for(int i=0;i<N;i++){
            // 如果返回-1，查找不成功
            // 如果返回j>i，计数器增加
            // 如果返回j<i, 重复，计数器不增加
            if(BinarySearch.rank(-a[i],a)>i){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        String arr = "http://algs4.cs.princeton.edu/14analysis/8Kints.txt";
        int[] a = In.readInts(arr);
        StdOut.println(count(a));
    }
}
