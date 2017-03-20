package com.algorithmsforimock.c5;

/**
 * 二分查找法
 * 对于有序数列，才能使用二分查找法（排序的作用）
 */
public class BinarySearch {
    // 如果找到target，返回相应的索引index
    // 如果没有找到target，返回-1
    public static Integer binarySearch(Integer[] arr,Integer target){
        // 在arr[l,r]中查找target
        int n = arr.length;
        int l=0,r=n-1;
        while(l<=r){
            int mid = l+(r-l)/2; // 用(l+r)/2容易溢出
            if(arr[mid].equals(target)){
                return mid;
            }
            if(target<arr[mid]){
                // 在arr[l,mid-1]中查找target
                r = mid-1;
            }else{
                // 在arr[mid+1,r]中查找target
                l = mid+1;
            }
        }
        return -1;
    }
}
