package com.algorithms.search;

import com.algorithms.model.In;
import com.algorithms.model.StdIn;
import com.algorithms.model.StdOut;

import java.util.Arrays;

/**
 * 二分查询
 * 数组如下
 * http://algs4.cs.princeton.edu/11model/tinyW.txt
 * http://algs4.cs.princeton.edu/11model/tinyT.txt
 * http://algs4.cs.princeton.edu/11model/largeW.txt
 * http://algs4.cs.princeton.edu/11model/largeT.txt
 */
public class BinarySearch {

    public static int rank(int key, int[] a){
        int lo = 0;
        int hi = a.length-1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(key< a[mid]){
                hi = mid -1;
            }else if(key >a[mid]){
                lo = mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String arr = "http://algs4.cs.princeton.edu/11model/tinyW.txt";
        int[] whitelist = In.readInts(arr);
        Arrays.sort(whitelist);
        while(!StdIn.isEmpty()){
            int key = StdIn.readInt();
            if(rank(key,whitelist)<0){
                StdOut.println(key);
            }
        }
    }
}
