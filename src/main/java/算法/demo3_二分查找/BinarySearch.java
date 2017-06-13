package 算法.demo3_二分查找;

import com.algorithms.model.StdRandom;

/**
 * 二分查找法
 * 对于有序数列，才能使用二分查找法（排序的作用）
 */
public class BinarySearch {
    // 如果找到target，返回相应的索引index
    // 如果没有找到target，返回-1
//    public static Integer binarySearch(Integer[] arr,Integer target){
//        // 在arr[l,r]中查找target
//        int n = arr.length;
//        int l=0,r=n-1;
//        while(l<=r){// l小于r就一直循环下去
//            int mid = l+(r-l)/2; // 用(l+r)/2容易溢出
//            if(arr[mid].equals(target)){
//                return mid;
//            }
//            if(target<arr[mid]){
//                // 在arr[l,mid-1]中查找target
//                r = mid-1;
//            }else{
//                // 在arr[mid+1,r]中查找target
//                l = mid+1;
//            }
//        }
//        return -1;
//    }

    public static Integer binarySearch(Integer[] arr,Integer target){
        int l = 0,r = arr.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]<target){
                l = mid+1;
            }else if(arr[mid]>target){
                r = mid-1;
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
