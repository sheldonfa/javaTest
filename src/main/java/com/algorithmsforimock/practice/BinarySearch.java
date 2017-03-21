package com.algorithmsforimock.practice;

import com.algorithms.model.StdRandom;

/**
 * @author fangxin
 * @description ${END}
 * @date 2017/3/21 0021.
 */
public class BinarySearch {

    public static Integer binarySearch(Integer[] arr, Integer target){
        int n = arr.length;
        int l = 0,r = n-1; //左闭右闭
        while(l<=r){
            int mid = l+(r-l)/2;
            if(target==arr[mid]){
                return mid;
            }else if(target<arr[mid]){
                r = mid-1;
            }else if(target>arr[mid]){
                l = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4,5,6,7,8,9};
        for(int i=0;i<100;i++){
            int uniform = StdRandom.uniform(0, 10);
            System.out.println("数字："+uniform);
            Integer target = binarySearch(arr, uniform);
            System.out.println("位置："+target);
        }
    }

}
